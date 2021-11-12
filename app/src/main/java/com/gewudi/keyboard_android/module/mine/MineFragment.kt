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