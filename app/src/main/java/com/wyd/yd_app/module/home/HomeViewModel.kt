package com.wyd.yd_app.module.home

import android.text.format.DateFormat
import androidx.lifecycle.viewModelScope
import com.wyd.yd_app.base.list.base.BaseRecyclerViewModel
import com.wyd.yd_app.base.list.base.BaseViewData
import com.wyd.yd_app.bean.FeedBean
import com.wyd.yd_app.constant.PageName
import com.wyd.yd_app.item.HomeItemViewData
import com.wyd.yd_app.item.Test1ViewData
import com.wyd.yd_app.item.Test2ViewData
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel : BaseRecyclerViewModel() {


    override fun loadData(isLoadMore: Boolean, isReLoad: Boolean, page: Int) {
        viewModelScope.launch {
            // 模拟网络数据加载
            delay(1000L)

            val time = DateFormat.format("MM-dd HH:mm:ss", System.currentTimeMillis())

            var data = FeedBean()
            data.cover_image = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic8.58cdn.com.cn%2Fzhuanzh%2Fn_v2782f698699fa422fb585a10dd8064097.jpg%3Fw%3D750%26h%3D0&refer=http%3A%2F%2Fpic8.58cdn.com.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1639225438&t=fd36998e700ef340fa57142c836db1e9"
            data.title = "键盘"
            val viewDataList: List<BaseViewData<*>>
            if (!isLoadMore) {
                viewDataList = listOf<BaseViewData<*>>(
                    HomeItemViewData(data),
                    HomeItemViewData( data),
                    HomeItemViewData( data),
                    HomeItemViewData( data),
                    HomeItemViewData( data),
                    HomeItemViewData( data),
                    HomeItemViewData( data),
                    HomeItemViewData( data),
                    HomeItemViewData( data),
                    HomeItemViewData( data),
                    HomeItemViewData( data),


//                    Test1ViewData("a-$time"),
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
                if (page == 5) {
                    postError(isLoadMore)
                    return@launch
                }
                viewDataList = listOf<BaseViewData<*>>(
                    Test1ViewData("a-$time"),
                    Test2ViewData("b-$time"),
                    Test1ViewData("c-$time"),
                    Test2ViewData("d-$time"),
                    Test1ViewData("e-$time"),
                    Test2ViewData("f-$time"),
                    Test1ViewData("g-$time"),
                    Test2ViewData("h-$time"),
                )
            }
            postData(isLoadMore, viewDataList)
            // postError(isLoadMore)
        }
    }

    @PageName
    override fun getPageName() = PageName.HOME
}