package com.wyd.yd_app.module.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.wyd.yd_app.base.BaseViewModel
import com.wyd.yd_app.bean.User
import com.wyd.yd_app.constant.PageName
import com.wyd.yd_app.network.UserNetworkApi
import com.wyd.yd_app.service.userservice.UserService
import kotlinx.coroutines.launch

class UserLoginViewModel : BaseViewModel() {
    val userLiveData = MutableLiveData<Result<User>>()

    //用户登录
    fun  userLoginWithPhone(phone: String, password:String) {

        viewModelScope.launch {
            val result = UserNetworkApi.requestUserPasswordLogin(phone, password)
            var user = result.getOrNull()
            user?.let { it ->
                UserService.instance.updateCurrentUser(it)
                user.uid?.let { uid ->
                    UserService.instance.loginWithUid(uid)
                }
            }
            userLiveData.value = result
        }
    }

    @PageName
    override fun getPageName() = PageName.USER_LOGIN
}