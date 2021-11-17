package com.gewudi.keyboard_android.constant

import androidx.annotation.IntDef

@IntDef(UserUpdateType.USER_NAME, UserUpdateType.USER_DESC, UserUpdateType.USER_GENDER, UserUpdateType.USER_AGE, UserUpdateType.USER_ADDRESS, UserUpdateType.USER_TAG,
        UserUpdateType.USER_QRCODE, UserUpdateType.USER_GWD_NO)
@Retention(AnnotationRetention.SOURCE)
annotation class UserUpdateType {
    companion object {
        const val USER_NAME = 1001
        const val USER_DESC = 1002
        const val USER_GENDER = 1003
        const val USER_AGE = 1004
        const val USER_ADDRESS = 1005
        const val USER_TAG = 1006
        const val USER_QRCODE = 1007
        const val USER_GWD_NO = 1008
    }
}
