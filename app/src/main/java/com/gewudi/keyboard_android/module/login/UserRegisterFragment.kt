package com.gewudi.keyboard_android.module.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.gewudi.keyboard_android.base.BaseFragment
import com.gewudi.keyboard_android.constant.EventName
import com.gewudi.keyboard_android.constant.PageName
import com.gewudi.keyboard_android.databinding.FragmentUserLoginBinding
import com.gewudi.keyboard_android.databinding.FragmentUserRegisterBinding
import com.gewudi.keyboard_android.eventbus.XEventBus

class UserRegisterFragment : BaseFragment<FragmentUserRegisterBinding>(FragmentUserRegisterBinding::inflate) {
    private val viewModel: UserLoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        viewModel.userLiveData.observe(viewLifecycleOwner) {
            var uid: Long? = it
            uid?.let {
                XEventBus.post(EventName.LOGIN, uid)
//                Toast.makeText(this, uid.toString(), Toast.LENGTH_SHORT).show()
            }
        }

        viewBinding.loginRegisterCardView.setOnClickListener {
            val phoneString = viewBinding.registerPhoneInputView.text.toString()
            val passwordString = viewBinding.registerPasswordInputView.text.toString()
            if (phoneString.isEmpty()) {
//                Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (passwordString.isEmpty()) {
//                Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            viewModel.userLoginWithPhone(phoneString,passwordString)
        }

    }

    @PageName
    override fun getPageName() = PageName.USER_REGISTER

}