package com.wyd.yd_app.network

import com.wyd.yd_app.constant.NetWorkUrl
import com.wyd.yd_app.network.base.BaseNetworkApi
import okhttp3.FormBody


/**
 * 网络请求具体实现
 */
object NetworkApi : BaseNetworkApi<INetworkService>(NetWorkUrl.BASE_URL) {

    //Test
    suspend fun requestPostTest(uid:String, phone: String, password: String) = getResult {
        val formBody: FormBody = FormBody.Builder()
            .add("phone",phone)
            .add("password", password)
            .build()

        service.requestPostTest(uid,formBody)
    }

    suspend fun requestGetTest(uid:String, phone: String, password: String) = getResult {
        service.requestGetTest(uid, phone, password)
    }

}