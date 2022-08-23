package com.wyd.yd_app.constant

import androidx.annotation.StringDef

/**
* 全局通知名
*/
@StringDef(EventName.REFRESH_HOME_LIST, EventName.TEST, EventName.LOGIN, EventName.USER_UPDATE)
@Retention(AnnotationRetention.SOURCE)
annotation class EventName {
    companion object {
        //首页刷新
        const val REFRESH_HOME_LIST = "refresh_home_list"
        const val TEST = "test"
        //用户登录成功
        const val LOGIN = "login"
        //用户信息更新
        const val USER_UPDATE = "user_update"
    }
}
