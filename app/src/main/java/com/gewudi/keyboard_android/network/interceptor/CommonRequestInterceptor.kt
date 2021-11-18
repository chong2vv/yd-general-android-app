package com.gewudi.keyboard_android.network.interceptor

import android.os.Build
import com.gewudi.keyboard_android.persistence.XKeyValue
import okhttp3.Interceptor
import okhttp3.Response
import java.security.Key

class CommonRequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()
        return chain.proceed(builder.build())
    }
}