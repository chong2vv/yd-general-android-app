package com.gewudi.keyboard_android.constant

import androidx.annotation.StringDef

@StringDef(Key.USER_ID)
@Retention(AnnotationRetention.SOURCE)
annotation class Key {
    companion object {
        const val USER_ID = "user_id"
    }
}
