package com.wyd.yd_app.base

import com.wyd.yd_app.constant.PageName

/**
 * 获取页面名称通用接口
 */
interface IGetPageName {

    @PageName
    fun getPageName(): String

}