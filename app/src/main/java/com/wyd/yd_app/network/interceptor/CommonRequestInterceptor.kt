package com.wyd.yd_app.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class CommonRequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()
        return chain.proceed(builder.build())
    }
}