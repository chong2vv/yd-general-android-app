package com.gewudi.keyboard_android.module.message

import com.gewudi.keyboard_android.base.BaseViewModel
import com.gewudi.keyboard_android.base.list.base.BaseRecyclerViewModel
import com.gewudi.keyboard_android.constant.PageName

class MessageViewModel : BaseRecyclerViewModel() {
    override fun loadData(isLoadMore: Boolean, isReLoad: Boolean, page: Int) {

    }

    @PageName
    override fun getPageName() = PageName.MESSAGE

}