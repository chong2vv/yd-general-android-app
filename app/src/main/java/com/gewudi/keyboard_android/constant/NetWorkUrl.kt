package com.gewudi.keyboard_android.constant

import androidx.annotation.StringDef

@StringDef(NetWorkUrl.BASE_URL,NetWorkUrl.USER_LOGIN_PASSWORD,NetWorkUrl.USER_REGISTER_PASSWORD)
@Retention(AnnotationRetention.SOURCE)
annotation class NetWorkUrl {
    companion object {
        const val BASE_URL = "http://182.92.154.139:8080/gewudi/"

        /**
         * User相关
         * */
        //手机号密码注册
        const val USER_REGISTER_PASSWORD = "user/user_register_password.json"
        //手机号密码登录
        const val USER_LOGIN_PASSWORD = "user/password_login.json"
        //用户更新手机号
        const val USER_UPDATE = "user/update.json"


        /**
         * 文章相关
         * */
    }
}
