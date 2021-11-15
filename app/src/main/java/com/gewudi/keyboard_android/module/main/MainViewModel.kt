package com.gewudi.keyboard_android.module.main

import androidx.lifecycle.viewModelScope
import com.gewudi.keyboard_android.base.BaseViewModel
import com.gewudi.keyboard_android.constant.PageName
import com.gewudi.keyboard_android.network.NetworkApi
import kotlinx.coroutines.launch

class MainViewModel : BaseViewModel() {

    @PageName
    override fun getPageName() = PageName.HOME

}