package com.gewudi.keyboard_android.network

import com.gewudi.keyboard_android.bean.User
import com.gewudi.keyboard_android.bean.VideoBean
import com.gewudi.keyboard_android.bean.test.TestBean
import com.gewudi.keyboard_android.network.base.BaseResponse
import okhttp3.FormBody
import retrofit2.http.*

interface INetworkService {
    //test
    @POST("test/post_test.json")
    suspend fun requestPostTest(@Header("uid") uid:String, @Body body: FormBody):BaseResponse<TestBean>

    @GET("test/get_test.json")
    suspend fun requestGetTest(@Header("uid") uid:String, @Query("phone") phone:String, @Query("password") password:String):BaseResponse<TestBean>

}