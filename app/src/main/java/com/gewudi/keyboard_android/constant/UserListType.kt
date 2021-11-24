package com.gewudi.keyboard_android.constant

import androidx.annotation.IntDef

/**
* 用户列表type
*/
@IntDef(UserListType.USER_LIKE, UserListType.USER_FANS)
@Retention(AnnotationRetention.SOURCE)
annotation class UserListType {
    companion object {
        // 我喜欢的
        const val USER_LIKE = 2001
        // 我的粉丝
        const val USER_FANS = 2002
    }
}