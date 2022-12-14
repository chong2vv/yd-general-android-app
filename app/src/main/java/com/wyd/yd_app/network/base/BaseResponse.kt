package com.wyd.yd_app.network.base

/**
 * 网络数据返回基类
 */
data class BaseResponse<T>(
    var errorCode: Int = 0,
    val errorMsg: String? = null,
    val result: T? = null
)
