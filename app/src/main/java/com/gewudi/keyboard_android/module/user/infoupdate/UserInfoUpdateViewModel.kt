package com.gewudi.keyboard_android.module.user.infoupdate

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.gewudi.keyboard_android.base.list.base.BaseRecyclerViewModel
import com.gewudi.keyboard_android.base.list.base.BaseViewData
import com.gewudi.keyboard_android.bean.User
import com.gewudi.keyboard_android.bean.UserUpdateBean
import com.gewudi.keyboard_android.constant.Key
import com.gewudi.keyboard_android.constant.PageName
import com.gewudi.keyboard_android.constant.UserUpdateType
import com.gewudi.keyboard_android.item.UserUpdateItemViewData
import com.gewudi.keyboard_android.network.UserNetworkApi
import com.gewudi.keyboard_android.persistence.XKeyValue
import com.gewudi.keyboard_android.persistence.database.XDatabase
import kotlinx.coroutines.launch

class UserInfoUpdateViewModel : BaseRecyclerViewModel() {
    val userLiveData = MutableLiveData<Result<User>>()
    override fun loadData(isLoadMore: Boolean, isReLoad: Boolean, page: Int) {
        viewModelScope.launch {
            val uid = XKeyValue.getLong(Key.USER_ID)
            if (uid > 0) {
                val user: User = XDatabase.userDao().findByUid(uid)
                user?.let {
                    val viewDataList: List<BaseViewData<*>> = listOf<BaseViewData<*>>(
                        UserUpdateItemViewData(
                            UserUpdateBean(
                                "名字",
                                user.username.toString(), UserUpdateType.USER_NAME
                            )
                        ),
                        UserUpdateItemViewData(
                            UserUpdateBean(
                                "简介",
                                user.user_desc.toString(), UserUpdateType.USER_DESC
                            )
                        ),
                        UserUpdateItemViewData(
                            UserUpdateBean(
                                "年龄",
                                user.age.toString(), UserUpdateType.USER_AGE
                            )
                        ),
                        UserUpdateItemViewData(
                            UserUpdateBean(
                                "地址",
                                user.address.toString(), UserUpdateType.USER_ADDRESS
                            )
                        ),
                        UserUpdateItemViewData(
                            UserUpdateBean(
                                "标签",
                                user.user_tag.toString(), UserUpdateType.USER_TAG
                            )
                        ),

                        )
                    postData(isLoadMore, viewDataList)
                }
            }
        }
    }

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
    override fun getPageName() = PageName.USER_INFO_UPDATE

}