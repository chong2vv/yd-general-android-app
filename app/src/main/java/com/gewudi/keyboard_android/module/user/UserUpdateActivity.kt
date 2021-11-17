package com.gewudi.keyboard_android.module.user

import android.os.Bundle
import androidx.activity.viewModels
import com.gewudi.keyboard_android.base.BaseActivity
import com.gewudi.keyboard_android.constant.PageName
import com.gewudi.keyboard_android.databinding.ActivityUserInfoBinding
import com.gewudi.keyboard_android.databinding.ActivityUserUpdateBinding
import com.gewudi.keyboard_android.module.login.LoginViewModel

class UserUpdateActivity : BaseActivity<ActivityUserUpdateBinding>(ActivityUserUpdateBinding::inflate) {

    private val viewModel: UserUpdateViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initSystemBar()
        initView()
    }

    private fun initView() {

    }

    @PageName
    override fun getPageName() = PageName.USER_UPDATE
}