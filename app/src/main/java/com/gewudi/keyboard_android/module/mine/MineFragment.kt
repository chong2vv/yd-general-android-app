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
import com.gewudi.keyboard_android.eventbus.XEventBus
import com.gewudi.keyboard_android.module.user.UserUpdateActivity
import com.gewudi.keyboard_android.persistence.XKeyValue
import com.gewudi.keyboard_android.persistence.database.XDatabase
import com.gewudi.keyboard_android.widget.TitleValueView
import kotlinx.coroutines.launch

/**
 * 我的
 */
class MineFragment : BaseFragment<FragmentMineBinding>(FragmentMineBinding::inflate) {

    private val viewModel: MineViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {

        viewBinding.userFaceImage.setOnClickListener {
            val uid = XKeyValue.getLong(Key.USER_ID)
            if (uid > 0) {
                startActivity(Intent(activity, UserUpdateActivity::class.java))
            }else {
                startActivity(Intent(activity, LoginActivity::class.java))
            }
        }

        setCountViewTitle()

        XEventBus.observe(viewLifecycleOwner, EventName.LOGIN) { message: Long ->
//            println("username: ========== "+message.username)
            val uid = message
            lifecycleScope.launch {
               var user = XDatabase.userDao().findByUid(uid)
                user.let {
                    viewBinding.nameView.text = user.username
                }
            }
        }

        viewBinding.rvList.init(
            XRecyclerView.Config()
                .setPullRefreshEnable(false)
                .setPullUploadMoreEnable(false)
                .setViewModel(viewModel)
                .setOnItemClickListener(object : XRecyclerView.OnItemClickListener {
                    override fun onItemClick(parent: RecyclerView, view: View, viewData: BaseViewData<*>, position: Int, id: Long) {
                        var data: BaseViewData<MineSetting> = viewData as BaseViewData<MineSetting>
//                        Toast.makeText(context, "条目点击: ${viewData.value}", Toast.LENGTH_SHORT).show()
                        Toast.makeText(context, "条目点击: ${data.value.title}", Toast.LENGTH_SHORT).show()
                    }
                })
        )
    }

    private fun setCountViewTitle() {
//        viewBinding.likeCountView.setParameter(TitleValueView.ParameterBuilder().setTitle().setValue())
        viewBinding.likeCountView.setTitleStr("关注")
        viewBinding.fansCountView.setTitleStr("粉丝")
        viewBinding.collectCountView.setTitleStr("获赞")
    }

//    XEventBus.observe(viewLifecycleOwner, EventName.REFRESH_HOME_LIST) { message: String ->
//
//    }

    @PageName
    override fun getPageName() = PageName.MINE

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        // 这里可以添加页面打点
    }
}