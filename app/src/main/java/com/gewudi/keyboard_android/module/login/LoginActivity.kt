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

//        viewModel.userLiveData.observe(this) {
//            var uid: Long? = it
//            uid?.let {
//                finish()
//                XEventBus.post(EventName.LOGIN, uid)
//                Toast.makeText(this, uid.toString(), Toast.LENGTH_SHORT).show()
//            }
//        }

//        viewBinding.fragmentTabHost

//        viewBinding.loginCardView.setOnClickListener {
//            val phoneString = viewBinding.phoneInputView.text.toString()
//            val passwordString = viewBinding.passwordInputView.text.toString()
//            if (phoneString.isEmpty()) {
//                Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }
//
//            if (passwordString.isEmpty()) {
//                Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }
//
//            viewModel.userLoginWithPhone(phoneString,passwordString)
//        }
    }

    @PageName
    override fun getPageName() = PageName.LOGIN
}