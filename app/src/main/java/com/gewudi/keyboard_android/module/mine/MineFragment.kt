package com.gewudi.keyboard_android.module.mine

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.gewudi.keyboard_android.base.BaseFragment
import com.gewudi.keyboard_android.base.list.XRecyclerView
import com.gewudi.keyboard_android.base.list.base.BaseViewData
import com.gewudi.keyboard_android.bean.MineSetting
import com.gewudi.keyboard_android.bean.User
import com.gewudi.keyboard_android.constant.PageName
import com.gewudi.keyboard_android.databinding.FragmentMineBinding
import com.gewudi.keyboard_android.module.about.AboutActivity
import com.gewudi.keyboard_android.module.login.LoginActivity
import com.gewudi.keyboard_android.constant.EventName
import com.gewudi.keyboard_android.constant.Key
import com.gewudi.keyboard_android.constant.UserListType
import com.gewudi.keyboard_android.eventbus.XEventBus
import com.gewudi.keyboard_android.module.user.UserListActivity
import com.gewudi.keyboard_android.module.user.UserUpdateActivity
import com.gewudi.keyboard_android.persistence.XKeyValue
import com.gewudi.keyboard_android.persistence.database.XDatabase
import com.gewudi.keyboard_android.widget.TitleValueView
import kotlinx.coroutines.launch
import com.lxj.xpopup.interfaces.OnConfirmListener

import com.lxj.xpopup.XPopup




/**
 * 我的
 */
class MineFragment : BaseFragment<FragmentMineBinding>(FragmentMineBinding::inflate) {

    private val viewModel: MineViewModel by viewModels()
    private var user:User = User()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {

        //同步用户信息
        syncUserInfo()

        viewBinding.userFaceImage.setOnClickListener {
            val uid = XKeyValue.getLong(Key.USER_ID)
            if (uid > 0) {
                startActivity(Intent(activity, UserUpdateActivity::class.java))
            }else {
                startActivity(Intent(activity, LoginActivity::class.java))
            }
        }

        XEventBus.observe(viewLifecycleOwner, EventName.LOGIN) { message: Long ->
            syncUserInfo()
        }

        viewModel.userLiveData.observe(viewLifecycleOwner) {
            syncUserInfo()
        }

        setCountViewTitle()

        viewBinding.rvList.init(
            XRecyclerView.Config()
                .setPullRefreshEnable(false)
                .setPullUploadMoreEnable(false)
                .setViewModel(viewModel)
                .setOnItemClickListener(object : XRecyclerView.OnItemClickListener {
                    override fun onItemClick(parent: RecyclerView, view: View, viewData: BaseViewData<*>, position: Int, id: Long) {
                        var data: BaseViewData<MineSetting> = viewData as BaseViewData<MineSetting>
                        Toast.makeText(context, "条目点击: ${data.value.title}", Toast.LENGTH_SHORT).show()
                    }
                })
        )
    }

    private fun syncUserInfo() {
        lifecycleScope.launch {
            val uid = XKeyValue.getLong(Key.USER_ID)
            uid.let {
                user = XDatabase.userDao().findByUid(uid)
                user.let {
                    viewBinding.nameView.text = user.username
                    viewBinding.descView.text = user.user_desc
                }
            }
        }
    }

    private fun setCountViewTitle() {
        //用户所关注人数，点击跳转用户列表
        viewBinding.likeCountView.setTitleStr("关注数")
        viewBinding.likeCountView.setOnClickListener {
            var intent = Intent(activity, UserListActivity::class.java)
            intent.putExtra("Type",UserListType.USER_LIKE)
            startActivity(intent)
        }
        //用户粉丝数，点击跳转用户列表
        viewBinding.fansCountView.setTitleStr("粉丝数")
        viewBinding.fansCountView.setOnClickListener {
            var intent = Intent(activity, UserListActivity::class.java)
            intent.putExtra("Type",UserListType.USER_FANS)
            startActivity(intent)
        }
        //用户获赞数，点击弹出用户获赞Dialog
        viewBinding.collectCountView.setTitleStr("获赞数")
        viewBinding.collectCountView.setOnClickListener {
            XPopup.Builder(context) //                        .hasNavigationBar(false)
                //                        .hasStatusBar(false)
                .isDestroyOnDismiss(true) //                        .dismissOnBackPressed(false)
                //                        .isViewMode(true)
                //                        .hasBlurBg(true)
                //                         .autoDismiss(false)
                //                        .popupAnimation(PopupAnimation.NoAnimation)
                .asConfirm("恭喜你！", "你当前以获得${user.like_count}点赞。",
                    "取消", "确定",
                    { }, null, false
                ).show()
        }
    }


    @PageName
    override fun getPageName() = PageName.MINE

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        // 这里可以添加页面打点
    }
}