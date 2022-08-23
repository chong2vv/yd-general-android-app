package com.wyd.yd_app.bean.mock

import com.wyd.yd_app.bean.User

class UserMock {

    fun getUser():User {
        var user = User()
        user.uid = 101010101
        user.user_phone = "15712921838"
        user.username = "七月"
        user.user_profile_pic = "https://img0.baidu.com/it/u=1100903835,2363206227&fm=26&fmt=auto"
        user.address = "北京"
        user.age = 30
        user.gender = 1
        user.user_tag = "键盘侠,技术宅,肥宅"
        user.level = 99
        return user
    }

}