package com.gewudi.keyboard_android.module.user

import androidx.lifecycle.MutableLiveData
import com.gewudi.keyboard_android.base.BaseViewModel
import com.gewudi.keyboard_android.constant.PageName

class UserInfoViewModel : BaseViewModel() {
    val userLiveData = MutableLiveData<Long?>()


    @PageName
    override fun getPageName() = PageName.USER_INFO
}