package com.wyd.yd_app.module.user

import android.os.Bundle
import androidx.activity.viewModels
import com.wyd.yd_app.base.BaseActivity
import com.wyd.yd_app.constant.PageName
import com.wyd.yd_app.databinding.ActivityUserUpdateBinding
import com.wyd.yd_app.module.user.infoupdate.UserInfoUpdateFragment


class UserUpdateActivity : BaseActivity<ActivityUserUpdateBinding>(ActivityUserUpdateBinding::inflate) {

    private val viewModel: UserUpdateViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initSystemBar()
        initView()
    }

    private fun initView() {
        supportFragmentManager.beginTransaction().replace(viewBinding.fragmentContainer.id,
            UserInfoUpdateFragment()
        ).commit()
    }

    @PageName
    override fun getPageName() = PageName.USER_UPDATE
}