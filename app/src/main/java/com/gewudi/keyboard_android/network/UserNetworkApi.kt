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

    //更新用户信息
    suspend fun requestUserUpdate(field_name:String, field_value:String) = UserNetworkApi.getResult {
        val formBody: FormBody = FormBody.Builder()
            .add("field_name",field_name)
            .add("field_value", field_value)
            .build()
        UserNetworkApi.service.requestUserUpdate(formBody)
    }

    suspend fun requestUserShow() = UserNetworkApi.getResult {
        UserNetworkApi.service.requestUserShow()
    }

}