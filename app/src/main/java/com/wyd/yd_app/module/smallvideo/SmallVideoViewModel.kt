package com.wyd.yd_app.module.smallvideo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.wyd.yd_app.base.BaseViewModel
import com.wyd.yd_app.bean.VideoBean
import com.wyd.yd_app.constant.PageName
import kotlinx.coroutines.launch

class SmallVideoViewModel : BaseViewModel() {

    val helloWorldLiveData = MutableLiveData<Result<VideoBean>>()

    fun requestVideoDetail(id: String) {
        viewModelScope.launch {

        }
    }

    @PageName
    override fun getPageName() = PageName.SMALL_VIDEO

}