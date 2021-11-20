package com.gewudi.keyboard_android.constant

import androidx.annotation.IntDef

@IntDef(UserListType.USER_LIKE, UserListType.USER_FANS)
@Retention(AnnotationRetention.SOURCE)
annotation class UserListType {
    companion object {
        const val USER_LIKE = 2001
        const val USER_FANS = 2002
    }
}