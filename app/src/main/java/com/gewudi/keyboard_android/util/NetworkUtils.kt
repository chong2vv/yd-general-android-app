package com.gewudi.keyboard_android.util

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.provider.Settings

fun isNetworkConnect(): Boolean {
    val cm = com.gewudi.keyboard_android.XArchApplication.instance.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return cm.activeNetworkInfo?.isAvailable ?: false
}

fun toNetworkSetting(context: Context) {
    val intent = Intent(Settings.ACTION_WIFI_SETTINGS)
    context.startActivity(intent)
}