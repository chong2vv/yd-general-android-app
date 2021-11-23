package com.gewudi.keyboard_android.module.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.gewudi.keyboard_android.base.BaseFragment
import com.gewudi.keyboard_android.constant.EventName
import com.gewudi.keyboard_android.constant.PageName
import com.gewudi.keyboard_android.databinding.FragmentUserLoginBinding
import com.gewudi.keyboard_android.databinding.FragmentUserRegisterBinding
import com.gewudi.keyboard_android.eventbus.XEventBus
import com.gewudi.keyboard_android.widget.NavigationView

class UserRegisterFragment : BaseFragment<FragmentUserRegisterBinding>(FragmentUserRegisterBinding::inflate) {
    private val viewModel: UserRegisterViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        //用户注册成功回调
        viewModel.userLiveData.observe(viewLifecycleOwner) {
            var user = it.getOrNull()
            user?.let {
                Toast.makeText(context, user.username.toString(), Toast.LENGTH_SHORT).show()
                XEventBus.post(EventName.USER_UPDATE, user.uid)
                activity?.finish()
            }
        }

        //用户点击注册
        viewBinding.loginRegisterCardView.setOnClickListener {
            val phoneString = viewBinding.registerPhoneInputView.text.toString()
            val passwordString = viewBinding.registerPasswordInputView.text.toString()
            val passwordTwiceString = viewBinding.registerPasswordTwiceInputView.text.toString()
            if (phoneString.isEmpty()) {
                Toast.makeText(context, "请输入手机号", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (passwordString.isEmpty()) {
                Toast.makeText(context, "请输入密码", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (passwordTwiceString.isEmpty()) {
                Toast.makeText(context, "请输入再次验证密码", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (passwordString != passwordTwiceString) {
                Toast.makeText(context, "两次输入密码不一致", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            viewModel.userRegisterWithPhone(phoneString,passwordString)
        }

        //用户点击去登录
        viewBinding.goToLoginView.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .remove(this)
                .commit()
        }

        viewBinding.navigationBar.setParameter(
            NavigationView.ParameterBuilder()
                .setShowBack(true)
                .setShowTitle(true)
                .setTitle("注册")
        )

    }

    @PageName
    override fun getPageName() = PageName.USER_REGISTER

}