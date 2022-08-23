package com.wyd.yd_app.constant

import androidx.annotation.IntDef

// 更新用户信息type
@IntDef(UserUpdateType.USER_NAME, UserUpdateType.USER_DESC, UserUpdateType.USER_GENDER, UserUpdateType.USER_AGE, UserUpdateType.USER_ADDRESS, UserUpdateType.USER_TAG,
        UserUpdateType.USER_QRCODE, UserUpdateType.USER_GWD_NO)
@Retention(AnnotationRetention.SOURCE)
annotation class UserUpdateType {
    companion object {
        //用户名
        const val USER_NAME = 1001
        //用户描述
        const val USER_DESC = 1002
        //用户性别
        const val USER_GENDER = 1003
        //用户年龄
        const val USER_AGE = 1004
        //用户地址
        const val USER_ADDRESS = 1005
        //用户标签
        const val USER_TAG = 1006
        //用户二维码
        const val USER_QRCODE = 1007
        //用户格物帝编号
        const val USER_GWD_NO = 1008
    }
}
