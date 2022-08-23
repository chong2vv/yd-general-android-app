package com.wyd.yd_app.network

import com.wyd.yd_app.bean.User
import com.wyd.yd_app.constant.NetWorkUrl
import com.wyd.yd_app.network.base.BaseResponse
import okhttp3.FormBody
import retrofit2.http.Body
import retrofit2.http.GET
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
    //更新用户信息
    @POST(NetWorkUrl.USER_UPDATE)
    suspend fun requestUserUpdate(@Header("uid") uid: Long, @Body body: FormBody): BaseResponse<User>
    //获取用户详情
    @GET(NetWorkUrl.USER_SHOW)
    suspend fun requestUserShow(@Header("uid") uid: Long):BaseResponse<User>
}