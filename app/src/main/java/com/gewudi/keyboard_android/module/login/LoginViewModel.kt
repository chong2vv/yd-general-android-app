package com.gewudi.keyboard_android.module.login

import androidx.lifecycle.MutableLiveData
import com.gewudi.keyboard_android.base.BaseViewModel
import com.gewudi.keyboard_android.constant.PageName

class LoginViewModel : BaseViewModel() {
    val userLiveData = MutableLiveData<Long?>()

    @PageName
    override fun getPageName() = PageName.LOGIN
}