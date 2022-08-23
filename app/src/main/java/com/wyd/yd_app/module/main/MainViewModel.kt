package com.wyd.yd_app.module.main

import com.wyd.yd_app.base.BaseViewModel
import com.wyd.yd_app.constant.PageName

class MainViewModel : BaseViewModel() {

    @PageName
    override fun getPageName() = PageName.HOME

}