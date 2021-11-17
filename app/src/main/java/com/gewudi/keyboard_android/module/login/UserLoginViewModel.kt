package com.gewudi.keyboard_android.module.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.gewudi.keyboard_android.base.BaseViewModel
import com.gewudi.keyboard_android.bean.User
import com.gewudi.keyboard_android.constant.PageName
import com.gewudi.keyboard_android.network.NetworkApi
import com.gewudi.keyboard_android.network.UserNetworkApi
import kotlinx.coroutines.launch

class UserLoginViewModel : BaseViewModel() {
    val userLiveData = MutableLiveData<Result<User>>()

    fun  userLoginWithPhone(phone: String, password:String) {

        viewModelScope.launch {
            val result = UserNetworkApi.requestUserPasswordLogin(phone, password)
            userLiveData.value = result
//            var user = UserMock().getUser()
//            user.uid?.let { XKeyValue.putLong(XKeyNameConst.USER_ID, it) }
//            XDatabase.userDao().insert(user)
//            userLiveData.value = user.uid
        }
    }

    @PageName
    override fun getPageName() = PageName.USER_LOGIN
}