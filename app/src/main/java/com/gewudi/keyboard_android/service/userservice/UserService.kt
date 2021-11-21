package com.gewudi.keyboard_android.service.userservice

import com.gewudi.keyboard_android.constant.Key
import com.gewudi.keyboard_android.persistence.XKeyValue
import com.gewudi.keyboard_android.persistence.database.XDatabase

class UserService private constructor() {
    companion object {
        val instance: UserService by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            UserService()
        }
    }

    fun getUid(): Long {
        val uid:Long = XKeyValue.getLong(Key.USER_ID)
        return uid
    }
}