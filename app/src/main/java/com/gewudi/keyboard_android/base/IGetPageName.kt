package com.gewudi.keyboard_android.base

import com.gewudi.keyboard_android.constant.PageName

/**
 * 获取页面名称通用接口
 */
interface IGetPageName {

    @PageName
    fun getPageName(): String

}