@file:JvmName("Logger")

package com.wyd.yd_app.util

import android.util.Log
import com.wyd.yd_app.BuildConfig
import java.util.*

private fun isLoggable(): Boolean {
    return BuildConfig.DEBUG
}

fun i(tag: String, fmt: String, vararg args: Any) {
    if (isLoggable()) {
        Log.i(tag, format(fmt, *args))
    }
}

fun d(tag: String, fmt: String, vararg args: Any) {
    if (isLoggable()) {
        Log.d(tag, format(fmt, *args))
    }
}

fun w(tag: String, fmt: String, vararg args: Any) {
    if (isLoggable()) {
        Log.w(tag, format(fmt, *args))
    }
}

fun e(tag: String, fmt: String, vararg args: Any) {
    if (isLoggable()) {
        Log.e(tag, format(fmt, *args))
    }
}

fun e(tag: String, t: Throwable, fmt: String, vararg args: Any) {
    if (isLoggable()) {
        Log.e(tag, format(fmt, *args), t)
    }
}

private fun format(fmt: String, vararg args: Any): String {
    return if (args.isEmpty()) {
        fmt
    } else {
        String.format(Locale.getDefault(), fmt, *args)
    }
}