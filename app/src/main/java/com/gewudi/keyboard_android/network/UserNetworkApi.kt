package com.gewudi.keyboard_android.network

import com.gewudi.keyboard_android.constant.NetWorkUrl
import com.gewudi.keyboard_android.network.base.BaseNetworkApi
import com.gewudi.keyboard_android.service.userservice.UserService
import okhttp3.FormBody

/**
 * 用户相关网络请求具体实现
 */
object UserNetworkApi : BaseNetworkApi<IUserNetworkService>(NetWorkUrl.BASE_URL)  {

    /**
     * 注册
     */
    suspend fun requestUserRegisterPassword(phone: String, password:String) = UserNetworkApi.getResult {
        val formBody: FormBody = FormBody.Builder()
            .add("phone",phone)
            .add("password", password)
            .build()

        UserNetworkApi.service.requestUserRegisterPassword(formBody)
    }

    /**
     * 登录
     */
    suspend fun requestUserPasswordLogin(phone: String, password:String) = UserNetworkApi.getResult {
        val formBody: FormBody = FormBody.Builder()
            .add("phone",phone)
            .add("password", password)
            .build()
        UserNetworkApi.service.requestUserPasswordLogin(formBody)
    }

    /**
     * 更新用户信息
     */
    suspend fun requestUserUpdate(field_name:String, field_value:String) = UserNetworkApi.getResult {
        val formBody: FormBody = FormBody.Builder()
            .add("field_name",field_name)
            .add("field_value", field_value)
            .build()
        UserNetworkApi.service.requestUserUpdate(UserService.instance.getUid(),formBody)
    }

    /**
     * 获取用户详情
     */
    suspend fun requestUserShow(uid: Long) = UserNetworkApi.getResult {
        UserNetworkApi.service.requestUserShow(uid)
    }

}