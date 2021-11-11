package com.gewudi.keyboard_android.network

import com.gewudi.keyboard_android.bean.VideoBean
import com.gewudi.keyboard_android.network.base.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface INetworkService {

    @GET("videodetail")
    suspend fun requestVideoDetail(@Query("id") id: String): BaseResponse<VideoBean>
}