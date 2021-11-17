package com.gewudi.keyboard_android.constant

import androidx.annotation.StringDef

@StringDef(PageName.MAIN, PageName.HOME, PageName.ACGN, PageName.SMALL_VIDEO, PageName.GOLD, PageName.MINE, PageName.ABOUT,
    PageName.LOGIN, PageName.USER_LOGIN, PageName.USER_REGISTER, PageName.USER_INFO, PageName.USER_UPDATE)
@Retention(AnnotationRetention.SOURCE)
annotation class PageName {
    companion object {
        const val MAIN = "main"
        const val HOME = "home"
        const val ACGN = "acgn"
        const val SMALL_VIDEO = "small_video"
        const val GOLD = "gold"
        const val MINE = "mine"
        const val ABOUT = "about"
        const val LOGIN = "login"
        const val USER_LOGIN = "user_login"
        const val USER_REGISTER = "user_register"
        const val USER_INFO = "user_info"
        const val USER_UPDATE = "user_update"
    }
}