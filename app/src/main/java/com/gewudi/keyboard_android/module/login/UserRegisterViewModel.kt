package com.gewudi.keyboard_android.module.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.gewudi.keyboard_android.base.BaseViewModel
import com.gewudi.keyboard_android.bean.mock.UserMock
import com.gewudi.keyboard_android.constant.Key
import com.gewudi.keyboard_android.constant.PageName
import com.gewudi.keyboard_android.network.NetworkApi
import com.gewudi.keyboard_android.network.UserNetworkApi
import com.gewudi.keyboard_android.persistence.XKeyValue
import com.gewudi.keyboard_android.persistence.database.XDatabase
import kotlinx.coroutines.launch

class UserRegisterViewModel : BaseViewModel() {
    val userLiveData = MutableLiveData<Long?>()

    fun  userLoginWithPhone(phone: String, password:String) {
        viewModelScope.launch {
            val result = UserNetworkApi.requestUserRegisterPassword(phone, password)
            if (result.isSuccess) {

            }else{

            }
            var user = UserMock().getUser()
            user.uid?.let { XKeyValue.putLong(Key.USER_ID, it) }
            XDatabase.userDao().insert(user)
            userLiveData.value = user.uid
        }
    }

    @PageName
    override fun getPageName() = PageName.USER_REGISTER
}