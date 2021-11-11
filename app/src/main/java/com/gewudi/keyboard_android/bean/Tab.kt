package com.gewudi.keyboard_android.bean

import com.gewudi.keyboard_android.base.BaseFragment
import com.gewudi.keyboard_android.constant.TabId
import kotlin.reflect.KClass

data class Tab(
    @TabId
    val id: String,
    val title: String,
    val icon: Int,
    val fragmentClz: KClass<out BaseFragment<*>>
)