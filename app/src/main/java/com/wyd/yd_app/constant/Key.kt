package com.wyd.yd_app.constant

import androidx.annotation.StringDef

/**
* MMKV本地存储key名
*/
@StringDef(Key.USER_ID)
@Retention(AnnotationRetention.SOURCE)
annotation class Key {
    companion object {
        //当前用户UID
        const val USER_ID = "user_id"
    }
}
