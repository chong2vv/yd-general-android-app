package com.gewudi.keyboard_android.network

import com.gewudi.keyboard_android.network.base.BaseNetworkApi

/**
 * 网络请求具体实现
 * 需要部署服务端：https://github.com/huannan/XArchServer
 */
object NetworkApi : BaseNetworkApi<INetworkService>("http://182.92.154.139:8080/gewudi") {

    suspend fun requestVideoDetail(id: String) = getResult {
        service.requestVideoDetail(id)
    }

    //Test
    suspend fun requestPostTest(uid:String, phone: String, password: String) = getResult {
        service.requestPostTest(uid, phone, password)
    }

    suspend fun requestGetTest(uid:String, phone: String, password: String) = getResult {
        service.requestGetTest(uid, phone, password)
    }

    //登录注册， 用户相关
    //注册
    suspend fun requestUserRegisterPassword(phone: String, password:String) = getResult {
        service.requestUserRegisterPassword(phone, password)
    }

    //登录
    suspend fun requestUserPasswordLogin(phone: String, password:String) = getResult {
        service.requestUserPasswordLogin(phone, password)
    }
}