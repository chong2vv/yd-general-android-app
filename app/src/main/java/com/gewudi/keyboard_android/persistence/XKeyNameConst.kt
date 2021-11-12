package com.gewudi.keyboard_android.persistence

import androidx.annotation.StringDef

@StringDef(XKeyNameConst.USER_ID)
@Retention(AnnotationRetention.SOURCE)
annotation class XKeyNameConst(){
    companion object {
        //uid
        const val USER_ID = "user_id"
    }
}

