package com.wyd.yd_app.module.login

import androidx.lifecycle.MutableLiveData
import com.wyd.yd_app.base.BaseViewModel
import com.wyd.yd_app.constant.PageName

class LoginViewModel : BaseViewModel() {
    val userLiveData = MutableLiveData<Long?>()

    @PageName
    override fun getPageName() = PageName.LOGIN
}