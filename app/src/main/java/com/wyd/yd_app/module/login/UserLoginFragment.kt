package com.wyd.yd_app.module.login

import android.os.Bundle
import android.view.View
import com.wyd.yd_app.base.BaseFragment
import com.wyd.yd_app.constant.EventName
import com.wyd.yd_app.constant.PageName
import com.wyd.yd_app.databinding.FragmentUserLoginBinding
import com.wyd.yd_app.eventbus.XEventBus
import android.widget.Toast
import androidx.fragment.app.*
import com.wyd.yd_app.widget.NavigationView


class UserLoginFragment : BaseFragment<FragmentUserLoginBinding>(FragmentUserLoginBinding::inflate) {
    private val viewModel: UserLoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {

        //用户登录成功回调
        viewModel.userLiveData.observe(viewLifecycleOwner) {
            var user = it.getOrNull()
            user?.let {
                Toast.makeText(context, user.username.toString(), Toast.LENGTH_SHORT).show()
                XEventBus.post(EventName.USER_UPDATE, user.uid)
                activity?.finish()
            }
        }

        //用户点击登录
        viewBinding.loginCardView.setOnClickListener {
            val phoneString = viewBinding.phoneInputView.text.toString()
            val passwordString = viewBinding.passwordInputView.text.toString()

            if (phoneString.isEmpty()) {
                Toast.makeText(context, "请输入手机号", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (passwordString.isEmpty()) {
                Toast.makeText(context, "请输入密码", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            viewModel.userLoginWithPhone(phoneString,passwordString)
        }

        //点击去注册
        viewBinding.goToRegisterView.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .add(this.id, UserRegisterFragment())
                .addToBackStack(null)
                .commit()
        }

        viewBinding.navigationBar.setParameter(
            NavigationView.ParameterBuilder()
                .setShowBack(true)
                .setShowTitle(true)
                .setTitle("登录")
        )
    }

    @PageName
    override fun getPageName() = PageName.USER_LOGIN

}