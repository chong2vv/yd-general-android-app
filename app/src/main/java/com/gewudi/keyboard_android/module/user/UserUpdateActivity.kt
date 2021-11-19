package com.gewudi.keyboard_android.module.user

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.gewudi.keyboard_android.base.BaseActivity
import com.gewudi.keyboard_android.base.list.XRecyclerView
import com.gewudi.keyboard_android.base.list.base.BaseViewData
import com.gewudi.keyboard_android.bean.UserUpdateBean
import com.gewudi.keyboard_android.constant.PageName
import com.gewudi.keyboard_android.constant.UserUpdateType
import com.gewudi.keyboard_android.databinding.ActivityUserUpdateBinding
import com.gewudi.keyboard_android.module.login.UserLoginFragment
import com.gewudi.keyboard_android.module.user.infoupdate.UserInfoUpdateFragment


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