package com.gewudi.keyboard_android.module.mine

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope

import com.gewudi.keyboard_android.base.list.base.BaseRecyclerViewModel
import com.gewudi.keyboard_android.base.list.base.BaseViewData
import com.gewudi.keyboard_android.bean.MineSetting
import com.gewudi.keyboard_android.bean.User
import com.gewudi.keyboard_android.constant.Key
import com.gewudi.keyboard_android.constant.PageName
import com.gewudi.keyboard_android.item.MineSettingItemViewData
import com.gewudi.keyboard_android.network.UserNetworkApi
import com.gewudi.keyboard_android.persistence.XKeyValue
import com.gewudi.keyboard_android.persistence.database.XDatabase
import com.gewudi.keyboard_android.service.userservice.UserService
import kotlinx.coroutines.launch

class MineViewModel : BaseRecyclerViewModel() {
    val userLiveData = MutableLiveData<User>()

    override fun loadData(isLoadMore: Boolean, isReLoad: Boolean, page: Int) {
        viewModelScope.launch {

            if (UserService.instance.isLogin()) {
                val result = UserNetworkApi.requestUserShow()
                var user = result.getOrNull()
                user?.let {
                    UserService.instance.updateCurrentUser(it)
                    userLiveData.value = it
                }
            }

            val viewDataList: List<BaseViewData<*>> = listOf<BaseViewData<*>>(
                MineSettingItemViewData(MineSetting(0,"我发布的")),
                MineSettingItemViewData(MineSetting(0,"我点赞的")),
                MineSettingItemViewData(MineSetting(0,"我收藏的")),
            )

            postData(isLoadMore, viewDataList)
        }
    }

    @PageName
    override fun getPageName() = PageName.MINE

}