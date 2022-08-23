package com.wyd.yd_app.network.interceptor

import com.wyd.yd_app.persistence.XKeyValue
import okhttp3.Interceptor
import okhttp3.Response

class UIDRequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()
        // 这里添加公共请求头
        val uid = XKeyValue.getLong(com.wyd.yd_app.constant.Key.USER_ID)
        uid.let {
            builder.addHeader("uid", uid.toString())
        }
        return chain.proceed(builder.build())
    }
}