package com.gewudi.keyboard_android.module.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.gewudi.keyboard_android.base.list.base.BaseRecyclerViewModel
import com.gewudi.keyboard_android.base.list.base.BaseViewData
import com.gewudi.keyboard_android.bean.MineSetting
import com.gewudi.keyboard_android.bean.User
import com.gewudi.keyboard_android.constant.Key
import com.gewudi.keyboard_android.constant.PageName
import com.gewudi.keyboard_android.constant.UserListType
import com.gewudi.keyboard_android.item.HomeItemViewData
import com.gewudi.keyboard_android.item.MineSettingItemViewData
import com.gewudi.keyboard_android.item.Test1ViewData
import kotlinx.coroutines.launch

class UserListViewModel : BaseRecyclerViewModel() {

    var user_list_type:Int? = UserListType.USER_LIKE
    override fun loadData(isLoadMore: Boolean, isReLoad: Boolean, page: Int) {
        viewModelScope.launch {

            val viewDataList: List<BaseViewData<*>>
            if (!isLoadMore) {
                viewDataList = listOf<BaseViewData<*>>(


//                    Test1ViewData("a-"),
//                    Test2ViewData("b-$time"),
//                    Test1ViewData("c-$time"),
//                    Test2ViewData("d-$time"),
//                    Test1ViewData("e-$time"),
//                    Test2ViewData("f-$time"),
//                    Test1ViewData("g-$time"),
//                    Test2ViewData("h-$time"),
                )
            }

            else {
                // 在第5页模拟网络异常
//                if (page == 5) {
//                    postError(isLoadMore)
//                    return@launch
//                }
                viewDataList = listOf<BaseViewData<*>>(
//                    Test1ViewData("a-"),
//                    Test2ViewData("b-$time"),
//                    Test1ViewData("c-$time"),
//                    Test2ViewData("d-$time"),
//                    Test1ViewData("e-$time"),
//                    Test2ViewData("f-$time"),
//                    Test1ViewData("g-$time"),
//                    Test2ViewData("h-$time"),
                )
            }
//            postData(isLoadMore, viewDataList)
            // postError(isLoadMore)
        }
        }

    @PageName
    override fun getPageName() = PageName.USER_LIST
}
