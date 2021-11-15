package com.gewudi.keyboard_android.network

import com.gewudi.keyboard_android.bean.User
import com.gewudi.keyboard_android.bean.VideoBean
import com.gewudi.keyboard_android.bean.test.TestBean
import com.gewudi.keyboard_android.network.base.BaseResponse
import retrofit2.http.*

interface INetworkService {

    @GET("videodetail")
    suspend fun requestVideoDetail(@Query("id") id: String): BaseResponse<VideoBean>

    //test
    @POST("/test/post_test.json")
    suspend fun requestPostTest(@Header("uid") uid:String, @Body phone:String, @Body password:String):BaseResponse<TestBean>

    @GET("/test/get_test.json")
    suspend fun requestGetTest(@Header("uid") uid:String, @Query("phone") phone:String, @Query("password") password:String):BaseResponse<TestBean>

    //user 登录注册
    //注册
    @GET("/user/user_register_password.json")
    suspend fun requestUserRegisterPassword(@Query("phone") phone:String, @Query("password") password:String):BaseResponse<User>
    //登录
    @GET("/user/password_login.json")
    suspend fun requestUserPasswordLogin(@Query("phone") phone:String, @Query("password") password:String):BaseResponse<User>
}