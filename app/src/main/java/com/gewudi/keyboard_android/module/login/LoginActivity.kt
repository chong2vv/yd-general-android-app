package com.gewudi.keyboard_android.module.login

import android.os.Bundle
import androidx.activity.viewModels
import com.gewudi.keyboard_android.base.BaseActivity
import com.gewudi.keyboard_android.constant.PageName
import com.gewudi.keyboard_android.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initSystemBar()
        initView()
    }

    private fun initView() {
        supportFragmentManager.beginTransaction().replace(viewBinding.fragmentContainer.id,UserLoginFragment()).commit()

    }

    @PageName
    override fun getPageName() = PageName.LOGIN
}