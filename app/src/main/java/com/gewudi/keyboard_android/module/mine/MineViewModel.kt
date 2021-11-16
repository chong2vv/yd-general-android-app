package com.gewudi.keyboard_android.module.mine

import androidx.lifecycle.viewModelScope

import com.gewudi.keyboard_android.base.list.base.BaseRecyclerViewModel
import com.gewudi.keyboard_android.base.list.base.BaseViewData
import com.gewudi.keyboard_android.bean.MineSetting
import com.gewudi.keyboard_android.constant.PageName
import com.gewudi.keyboard_android.item.MineSettingItemViewData
import kotlinx.coroutines.launch

class MineViewModel : BaseRecyclerViewModel() {
    override fun loadData(isLoadMore: Boolean, isReLoad: Boolean, page: Int) {
        viewModelScope.launch {
            val viewDataList: List<BaseViewData<*>> = listOf<BaseViewData<*>>(
                MineSettingItemViewData(MineSetting(0,"我发布的")),
                MineSettingItemViewData(MineSetting(0,"我点赞的")),
                MineSettingItemViewData(MineSetting(0,"我收藏的"))
            )

            postData(isLoadMore, viewDataList)
        }
    }

    @PageName
    override fun getPageName() = PageName.MINE

}