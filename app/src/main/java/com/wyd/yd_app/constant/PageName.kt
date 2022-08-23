package com.wyd.yd_app.constant

import androidx.annotation.StringDef

@StringDef(PageName.MAIN, PageName.HOME, PageName.ACGN, PageName.SMALL_VIDEO, PageName.MESSAGE, PageName.MINE, PageName.ABOUT,
    PageName.LOGIN, PageName.USER_LOGIN, PageName.USER_REGISTER, PageName.USER_INFO, PageName.USER_UPDATE, PageName.USER_INFO_CHANGE,
    PageName.USER_INFO_UPDATE, PageName.USER_LIST)
@Retention(AnnotationRetention.SOURCE)
annotation class PageName {
    companion object {
        //主activity
        const val MAIN = "main"
        //首页
        const val HOME = "home"
        const val ACGN = "acgn"
        const val SMALL_VIDEO = "small_video"
        //消息
        const val MESSAGE = "message"
        //我的
        const val MINE = "mine"
        const val ABOUT = "about"
        //注册登录activity
        const val LOGIN = "login"
        //登录
        const val USER_LOGIN = "user_login"
        //注册
        const val USER_REGISTER = "user_register"
        //查看用户信息
        const val USER_INFO = "user_info"
        //用户列表
        const val USER_LIST = "user_list"
        //用户信息更新activity
        const val USER_UPDATE = "user_update"
        //当前用户信息展示
        const val USER_INFO_UPDATE = "user_info_update"
        //用户信息编辑
        const val USER_INFO_CHANGE = "user_info_change"
    }
}