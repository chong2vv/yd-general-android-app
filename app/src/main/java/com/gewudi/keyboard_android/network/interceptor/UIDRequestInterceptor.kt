package com.gewudi.keyboard_android.network.interceptor

import com.gewudi.keyboard_android.persistence.XKeyValue
import okhttp3.Interceptor
import okhttp3.Response

class UIDRequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()
        // 这里添加公共请求头
        val uid = XKeyValue.getLong(com.gewudi.keyboard_android.constant.Key.USER_ID)
        uid.let {
            builder.addHeader("uid", uid.toString())
        }
        return chain.proceed(builder.build())
    }
}