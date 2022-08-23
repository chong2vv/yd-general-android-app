package com.wyd.yd_app.module.user.infoupdate

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.wyd.yd_app.base.BaseViewModel
import com.wyd.yd_app.bean.User
import com.wyd.yd_app.constant.Key
import com.wyd.yd_app.constant.PageName
import com.wyd.yd_app.network.UserNetworkApi
import com.wyd.yd_app.persistence.XKeyValue
import com.wyd.yd_app.persistence.database.XDatabase
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