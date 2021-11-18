package com.gewudi.keyboard_android.module.user.infoupdate

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.gewudi.keyboard_android.base.BaseViewModel
import com.gewudi.keyboard_android.bean.User
import com.gewudi.keyboard_android.constant.Key
import com.gewudi.keyboard_android.constant.PageName
import com.gewudi.keyboard_android.network.UserNetworkApi
import com.gewudi.keyboard_android.persistence.XKeyValue
import com.gewudi.keyboard_android.persistence.database.XDatabase
import kotlinx.coroutines.launch

class UserInfoChangeViewModel : BaseViewModel() {
    val userLiveData = MutableLiveData<Result<User>>()

    fun  userInfoUpdate(key: String, value:String) {

        viewModelScope.launch {
            val result = UserNetworkApi.requestUserUpdate(key, value)
            var user = result.getOrNull()
            user?.let {
                XDatabase.userDao().insert(user)

                user.uid?.let {
                    XKeyValue.putLong(Key.USER_ID, it)
                }
            }
            userLiveData.value = result
        }
    }

    @PageName
    override fun getPageName() = PageName.USER_INFO_CHANGE
}