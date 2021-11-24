package com.gewudi.keyboard_android.constant

import androidx.annotation.StringDef

@StringDef(TabId.HOME, TabId.ACGN, TabId.SMALL_VIDEO, TabId.MESSAGE, TabId.MINE)
@Retention(AnnotationRetention.SOURCE)
annotation class TabId {
    companion object {
        //首页
        const val HOME = "home"
        const val ACGN = "acgn"
        const val SMALL_VIDEO = "small_video"
        const val MESSAGE = "message"
        //我的
        const val MINE = "mine"
    }
}