package com.wyd.yd_app.module.user

import androidx.lifecycle.MutableLiveData
import com.wyd.yd_app.base.BaseViewModel
import com.wyd.yd_app.constant.PageName

class UserInfoViewModel : BaseViewModel() {
    val userLiveData = MutableLiveData<Long?>()


    @PageName
    override fun getPageName() = PageName.USER_INFO
}