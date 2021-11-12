package com.gewudi.keyboard_android.module.login

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.gewudi.keyboard_android.base.BaseActivity
import com.gewudi.keyboard_android.constant.EventName
import com.gewudi.keyboard_android.constant.PageName
import com.gewudi.keyboard_android.databinding.ActivityLoginBinding
import com.gewudi.keyboard_android.eventbus.XEventBus
import com.gewudi.keyboard_android.network.base.BaseNetworkApi
import com.gewudi.keyboard_android.persistence.XKeyNameConst
import com.gewudi.keyboard_android.persistence.XKeyValue
import com.gewudi.keyboard_android.persistence.database.XDatabase
import com.gewudi.keyboard_android.util.d
import com.gewudi.keyboard_android.util.i
import java.util.logging.Logger

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        viewModel.userLiveData.observe(this) {
            var uid: Long? = it
            uid?.let {
                finish()
                XEventBus.post(EventName.LOGIN, uid)
                Toast.makeText(this, uid.toString(), Toast.LENGTH_SHORT).show()
            }
        }

        viewBinding.loginCardView.setOnClickListener {
            val phoneString = viewBinding.phoneInputView.text.toString()
            val passwordString = viewBinding.passwordInputView.text.toString()
            if (phoneString.isEmpty()) {
                Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (passwordString.isEmpty()) {
                Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            viewModel.userLoginWithPhone(phoneString,passwordString)
        }
    }

    @PageName
    override fun getPageName() = PageName.LOGIN
}