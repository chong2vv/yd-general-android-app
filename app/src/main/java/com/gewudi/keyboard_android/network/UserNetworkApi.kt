package com.gewudi.keyboard_android.network

import com.gewudi.keyboard_android.constant.NetWorkUrl
import com.gewudi.keyboard_android.network.base.BaseNetworkApi
import okhttp3.FormBody

object UserNetworkApi : BaseNetworkApi<IUserNetworkService>(NetWorkUrl.BASE_URL)  {

    //登录注册， 用户相关
    //注册
    suspend fun requestUserRegisterPassword(phone: String, password:String) = UserNetworkApi.getResult {
        val formBody: FormBody = FormBody.Builder()
            .add("phone",phone)
            .add("password", password)
            .build()

        UserNetworkApi.service.requestUserRegisterPassword(formBody)
    }

    //登录
    suspend fun requestUserPasswordLogin(phone: String, password:String) = UserNetworkApi.getResult {
        val formBody: FormBody = FormBody.Builder()
            .add("phone",phone)
            .add("password", password)
            .build()
        UserNetworkApi.service.requestUserPasswordLogin(formBody)
    }

}