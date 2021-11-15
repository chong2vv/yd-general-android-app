package com.gewudi.keyboard_android.module.mine

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.gewudi.keyboard_android.base.BaseFragment
import com.gewudi.keyboard_android.bean.User
import com.gewudi.keyboard_android.constant.PageName
import com.gewudi.keyboard_android.databinding.FragmentMineBinding
import com.gewudi.keyboard_android.module.about.AboutActivity
import com.gewudi.keyboard_android.module.login.LoginActivity
import com.gewudi.keyboard_android.constant.EventName
import com.gewudi.keyboard_android.eventbus.XEventBus
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
        viewBinding.tvMine.setOnClickListener {
            startActivity(Intent(activity, AboutActivity::class.java))
        }

        viewBinding.userFaceImage.setOnClickListener {
            startActivity(Intent(activity, LoginActivity::class.java))
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