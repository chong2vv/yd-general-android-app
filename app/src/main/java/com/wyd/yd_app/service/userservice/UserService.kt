package com.wyd.yd_app.service.userservice

import com.wyd.yd_app.bean.User
import com.wyd.yd_app.constant.Key
import com.wyd.yd_app.persistence.XKeyValue
import com.wyd.yd_app.persistence.database.XDatabase

class UserService private constructor() {
    companion object {
        val instance: UserService by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            UserService()
        }
    }

    /**
    * 登录保存用户uid
    */
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