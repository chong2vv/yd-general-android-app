package com.wyd.yd_app.constant

import androidx.annotation.IntDef

@IntDef(ErrorCode.OK, ErrorCode.UNAUTHORIZED, ErrorCode.CUSTOM_FIRST, ErrorCode.VALUE_IS_NULL)
@Retention(AnnotationRetention.SOURCE)
annotation class ErrorCode {
    companion object {
        const val OK = 0
        const val SYSTEM_ERROR = 10000
        const val UNAUTHORIZED = 401
        const val CUSTOM_FIRST = 600
        const val VALUE_IS_NULL = CUSTOM_FIRST + 1
    }
}