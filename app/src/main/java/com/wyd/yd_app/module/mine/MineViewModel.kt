package com.wyd.yd_app.module.mine

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope

import com.wyd.yd_app.base.list.base.BaseRecyclerViewModel
import com.wyd.yd_app.base.list.base.BaseViewData
import com.wyd.yd_app.bean.MineSetting
import com.wyd.yd_app.bean.User
import com.wyd.yd_app.constant.PageName
import com.wyd.yd_app.item.MineSettingItemViewData
import com.wyd.yd_app.network.UserNetworkApi
import com.wyd.yd_app.service.userservice.UserService
import kotlinx.coroutines.launch

class MineViewModel : BaseRecyclerViewModel() {
    val userLiveData = MutableLiveData<User>()

    override fun loadData(isLoadMore: Boolean, isReLoad: Boolean, page: Int) {
        viewModelScope.launch {

            if (UserService.instance.isLogin()) {
                val result = UserNetworkApi.requestUserShow(UserService.instance.getUid())
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