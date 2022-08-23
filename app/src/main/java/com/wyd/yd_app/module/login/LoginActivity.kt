package com.wyd.yd_app.module.login

import android.os.Bundle
import androidx.activity.viewModels
import com.wyd.yd_app.base.BaseActivity
import com.wyd.yd_app.constant.PageName
import com.wyd.yd_app.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initSystemBar()
        initView()
    }

    private fun initView() {
        // 初始化启动登录fragment
        supportFragmentManager.beginTransaction().replace(viewBinding.fragmentContainer.id,UserLoginFragment()).commit()
    }

    @PageName
    override fun getPageName() = PageName.LOGIN
}