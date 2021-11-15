package com.gewudi.keyboard_android.module.mine

import com.gewudi.keyboard_android.base.BaseViewModel
import com.gewudi.keyboard_android.base.list.base.BaseRecyclerViewModel
import com.gewudi.keyboard_android.base.list.base.BaseViewData
import com.gewudi.keyboard_android.bean.MineSetting
import com.gewudi.keyboard_android.constant.PageName
import com.gewudi.keyboard_android.item.MineSettingItemViewData
import com.gewudi.keyboard_android.item.Test1ViewData
import com.gewudi.keyboard_android.item.Test2ViewData

class MineViewModel : BaseRecyclerViewModel() {
    override fun loadData(isLoadMore: Boolean, isReLoad: Boolean, page: Int) {
        val viewDataList: List<BaseViewData<*>> = listOf<BaseViewData<*>>(
            MineSettingItemViewData(MineSetting(0,"我发布的")),
            MineSettingItemViewData(MineSetting(0,"我点赞的")),
            MineSettingItemViewData(MineSetting(0,"我收藏的"))
        )

        postData(false, viewDataList)
    }

    @PageName
    override fun getPageName() = PageName.MINE

}