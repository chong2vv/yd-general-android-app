package com.wyd.yd_app.module.user.infoupdate

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.wyd.yd_app.base.list.base.BaseRecyclerViewModel
import com.wyd.yd_app.base.list.base.BaseViewData
import com.wyd.yd_app.bean.User
import com.wyd.yd_app.bean.UserUpdateBean
import com.wyd.yd_app.constant.PageName
import com.wyd.yd_app.constant.UserUpdateType
import com.wyd.yd_app.item.UserUpdateItemViewData
import com.wyd.yd_app.network.UserNetworkApi
import com.wyd.yd_app.service.userservice.UserService
import kotlinx.coroutines.launch

class UserInfoUpdateViewModel : BaseRecyclerViewModel() {
    val userLiveData = MutableLiveData<Result<User>>()

    /**
     * 获取用户本地信息展示
     */
    override fun loadData(isLoadMore: Boolean, isReLoad: Boolean, page: Int) {
        viewModelScope.launch {

            if (UserService.instance.isLogin()) {
                val user: User = UserService.instance.getCurrentUser()
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

    /**
     * 更新用户信息，头像、地址、生日等
     */
    fun  userInfoUpdate(key: String, value:String) {

        viewModelScope.launch {
            val result = UserNetworkApi.requestUserUpdate(key, value)
            var user = result.getOrNull()
            user?.let {
                UserService.instance.updateCurrentUser(user)
            }
            userLiveData.value = result
        }
    }

    @PageName
    override fun getPageName() = PageName.USER_INFO_UPDATE

}