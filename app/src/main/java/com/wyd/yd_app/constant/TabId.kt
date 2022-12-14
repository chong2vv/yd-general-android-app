package com.wyd.yd_app.constant

import androidx.annotation.StringDef

@StringDef(TabId.HOME, TabId.ACGN, TabId.SMALL_VIDEO, TabId.MESSAGE, TabId.MINE)
@Retention(AnnotationRetention.SOURCE)
annotation class TabId {
    companion object {
        //้ฆ้กต
        const val HOME = "home"
        const val ACGN = "acgn"
        const val SMALL_VIDEO = "small_video"
        const val MESSAGE = "message"
        //ๆ็
        const val MINE = "mine"
    }
}