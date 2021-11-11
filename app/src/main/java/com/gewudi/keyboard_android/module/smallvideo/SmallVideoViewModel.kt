package com.gewudi.keyboard_android.module.smallvideo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.gewudi.keyboard_android.base.BaseViewModel
import com.gewudi.keyboard_android.bean.VideoBean
import com.gewudi.keyboard_android.constant.PageName
import com.gewudi.keyboard_android.network.NetworkApi
import kotlinx.coroutines.launch

class SmallVideoViewModel : BaseViewModel() {

    val helloWorldLiveData = MutableLiveData<Result<VideoBean>>()

    fun requestVideoDetail(id: String) {
        viewModelScope.launch {
            val result = NetworkApi.requestVideoDetail(id)
            helloWorldLiveData.value = result
        }
    }

    @PageName
    override fun getPageName() = PageName.SMALL_VIDEO

}