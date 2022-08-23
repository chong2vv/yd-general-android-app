package com.wyd.yd_app.module.user

import android.os.Bundle
import androidx.activity.viewModels
import com.wyd.yd_app.base.BaseActivity
import com.wyd.yd_app.constant.PageName
import com.wyd.yd_app.databinding.ActivityUserInfoBinding

class UserInfoActivity : BaseActivity<ActivityUserInfoBinding>(ActivityUserInfoBinding::inflate) {

    private val viewModel: UserInfoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initSystemBar()
        initView()
    }

    private fun initView() {

    }

    @PageName
    override fun getPageName() = PageName.USER_INFO
}