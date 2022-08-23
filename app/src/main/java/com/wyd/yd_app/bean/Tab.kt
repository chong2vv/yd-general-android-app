package com.wyd.yd_app.bean

import com.wyd.yd_app.base.BaseFragment
import com.wyd.yd_app.constant.TabId
import kotlin.reflect.KClass

/**
* 底部Tab数据源
*/
data class Tab(
    @TabId
    val id: String,
    val title: String,
    val icon: Int,
    val fragmentClz: KClass<out BaseFragment<*>>
)