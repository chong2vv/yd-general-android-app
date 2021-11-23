package com.gewudi.keyboard_android.module.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.gewudi.keyboard_android.base.BaseViewModel
import com.gewudi.keyboard_android.bean.User
import com.gewudi.keyboard_android.bean.mock.UserMock
import com.gewudi.keyboard_android.constant.Key
import com.gewudi.keyboard_android.constant.PageName
import com.gewudi.keyboard_android.network.NetworkApi
import com.gewudi.keyboard_android.network.UserNetworkApi
import com.gewudi.keyboard_android.persistence.XKeyValue
import com.gewudi.keyboard_android.persistence.database.XDatabase
import com.gewudi.keyboard_android.service.userservice.UserService
import kotlinx.coroutines.launch

class UserRegisterViewModel : BaseViewModel() {
    val userLiveData = MutableLiveData<Result<User>>()

    //用户注册
    fun  userRegisterWithPhone(phone: String, password:String) {
        viewModelScope.launch {
            val result = UserNetworkApi.requestUserRegisterPassword(phone, password)
            var user = result.getOrNull()
            user?.let {
                UserService.instance.updateCurrentUser(it)

                user.uid?.let { uid ->
                    UserService.instance.loginWithUid(uid)
                }
            }
            userLiveData.value = result
        }
    }

    @PageName
    override fun getPageName() = PageName.USER_REGISTER
}