package com.gewudi.keyboard_android.bean

/**
* 用户信息Item数据源
*/
data class UserUpdateBean(
    //当前用户信息显示title，如：用户名、用户地址
    var title: String,
    //当前用户信息值, 如：七月、北京
    var value: String,
    // 更新用户信息type -> USerUpdateType类
    var type: Int
)

