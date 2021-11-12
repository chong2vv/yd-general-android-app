package com.gewudi.keyboard_android.constant

import androidx.annotation.StringDef

@StringDef(EventName.REFRESH_HOME_LIST, EventName.TEST, EventName.LOGIN)
@Retention(AnnotationRetention.SOURCE)
annotation class EventName {
    companion object {
        const val REFRESH_HOME_LIST = "refresh_home_list"
        const val TEST = "test"
        const val LOGIN = "login"
    }
}
