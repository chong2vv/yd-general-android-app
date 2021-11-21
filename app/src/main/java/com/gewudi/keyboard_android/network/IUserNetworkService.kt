package com.gewudi.keyboard_android.network

import com.gewudi.keyboard_android.bean.User
import com.gewudi.keyboard_android.constant.NetWorkUrl
import com.gewudi.keyboard_android.network.base.BaseResponse
import okhttp3.FormBody
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface IUserNetworkService {
    //user 登录注册
    //注册
    @POST(NetWorkUrl.USER_REGISTER_PASSWORD)
    suspend fun requestUserRegisterPassword(@Body body: FormBody): BaseResponse<User>
    //登录
    @POST(NetWorkUrl.USER_LOGIN_PASSWORD)
    suspend fun requestUserPasswordLogin(@Body body: FormBody): BaseResponse<User>
    //登录
    @POST(NetWorkUrl.USER_UPDATE)
    suspend fun requestUserUpdate(@Header("uid") uid: Long, @Body body: FormBody): BaseResponse<User>

    @POST(NetWorkUrl.USER_SHOW)
    suspend fun requestUserShow():BaseResponse<User>
}