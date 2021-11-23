package com.gewudi.keyboard_android.service.userservice

import com.gewudi.keyboard_android.bean.User
import com.gewudi.keyboard_android.constant.Key
import com.gewudi.keyboard_android.persistence.XKeyValue
import com.gewudi.keyboard_android.persistence.database.XDatabase

class UserService private constructor() {
    companion object {
        val instance: UserService by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            UserService()
        }
    }

    fun loginWithUid(uid: Long) {
        XKeyValue.putLong(Key.USER_ID, uid)
    }

    /**
     * 获取当前用户uid
     */
    fun getUid(): Long {
        val uid:Long = XKeyValue.getLong(Key.USER_ID)
        return uid
    }

    /**
     * 判断当前用户是否登陆
     */
    fun isLogin():Boolean {
        val uid:Long = getUid()
        if (uid > 0){
            return true
        }
        return false
    }

    /**
     * 获取当前登陆的用户信息
     */
    suspend fun getCurrentUser(): User {
        return XDatabase.userDao().findByUid(getUid())
    }

    /**
     * 更新当前用户信息，DB没有则新建
     */
    suspend fun updateCurrentUser(user:User) {
        XDatabase.userDao().insert(user)
    }
}