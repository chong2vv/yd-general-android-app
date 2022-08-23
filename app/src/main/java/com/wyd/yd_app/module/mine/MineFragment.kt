package com.wyd.yd_app.module.mine

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.wyd.yd_app.base.BaseFragment
import com.wyd.yd_app.base.list.XRecyclerView
import com.wyd.yd_app.base.list.base.BaseViewData
import com.wyd.yd_app.bean.MineSetting
import com.wyd.yd_app.bean.User
import com.wyd.yd_app.constant.PageName
import com.wyd.yd_app.databinding.FragmentMineBinding
import com.wyd.yd_app.module.login.LoginActivity
import com.wyd.yd_app.constant.EventName
import com.wyd.yd_app.constant.UserListType
import com.wyd.yd_app.eventbus.XEventBus
import com.wyd.yd_app.module.user.UserListActivity
import com.wyd.yd_app.module.user.UserUpdateActivity
import com.wyd.yd_app.service.userservice.UserService
import kotlinx.coroutines.launch

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
        if (UserService.instance.isLogin()) {
            syncUserInfo()
        }

        viewBinding.userFaceImage.setOnClickListener {
            when(UserService.instance.isLogin()) {
                true -> {
                    startActivity(Intent(activity, UserUpdateActivity::class.java))
                }
                false -> {
                    startActivity(Intent(activity, LoginActivity::class.java))
                }
            }
        }

        //接到消息，同步本地数据库信息到UI
        XEventBus.observe(viewLifecycleOwner, EventName.USER_UPDATE) { message: Long ->
            syncUserInfo()
        }

        //请求服务端最新用户信息后同步本地数据库信息到UI
        viewModel.userLiveData.observe(viewLifecycleOwner) {
            syncUserInfo()
        }

        setCountViewTitle()

        //点击cell
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

    /**
     * 同步用户本地信息
     */
    private fun syncUserInfo() {
        lifecycleScope.launch {
            user = UserService.instance.getCurrentUser()
            user.let {
                viewBinding.nameView.text = user.username
                viewBinding.descView.text = user.user_desc
            }
        }
    }

    /**
     * 设置用户点赞、粉丝、关注等数，添加点击方法
     */
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