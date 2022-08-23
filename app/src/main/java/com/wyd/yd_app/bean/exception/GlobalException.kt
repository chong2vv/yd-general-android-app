package com.wyd.yd_app.bean.exception

class GlobalException private constructor(message: String) : RuntimeException(message) {
    companion object {
        fun of(message: String) = GlobalException(message)
    }
}