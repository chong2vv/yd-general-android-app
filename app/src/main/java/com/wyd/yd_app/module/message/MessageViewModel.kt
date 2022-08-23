package com.wyd.yd_app.module.message

import com.wyd.yd_app.base.list.base.BaseRecyclerViewModel
import com.wyd.yd_app.constant.PageName

class MessageViewModel : BaseRecyclerViewModel() {
    override fun loadData(isLoadMore: Boolean, isReLoad: Boolean, page: Int) {

    }

    @PageName
    override fun getPageName() = PageName.MESSAGE

}