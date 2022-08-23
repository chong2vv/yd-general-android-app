package com.wyd.yd_app.module.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.wyd.yd_app.base.BaseFragment
import com.wyd.yd_app.base.list.XRecyclerView
import com.wyd.yd_app.base.list.base.BaseViewData
import com.wyd.yd_app.constant.EventName
import com.wyd.yd_app.constant.PageName
import com.wyd.yd_app.databinding.FragmentHomeBinding
import com.wyd.yd_app.eventbus.XEventBus

/**
 * 首页
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        viewBinding.rvList.init(
            XRecyclerView.Config()
                .setLayoutManager(StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL))
                .setViewModel(viewModel)
                .setOnItemClickListener(object : XRecyclerView.OnItemClickListener {
                    override fun onItemClick(parent: RecyclerView, view: View, viewData: BaseViewData<*>, position: Int, id: Long) {
                        Toast.makeText(context, "条目点击: ${viewData.value}", Toast.LENGTH_SHORT).show()
                    }
                })
                .setOnItemChildViewClickListener(object : XRecyclerView.OnItemChildViewClickListener {
                    override fun onItemChildViewClick(parent: RecyclerView, view: View, viewData: BaseViewData<*>, position: Int, id: Long, extra: Any?) {
                        if (extra is String) {
                            Toast.makeText(context, "条目子View点击: $extra", Toast.LENGTH_SHORT).show()
                        }
                    }
                })
        )

        XEventBus.observe(viewLifecycleOwner, EventName.REFRESH_HOME_LIST) { message: String ->
            viewBinding.rvList.refreshList()
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }

        XEventBus.observe(viewLifecycleOwner, EventName.TEST) { message: String ->
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }

    @PageName
    override fun getPageName() = PageName.HOME

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        // 这里可以添加页面打点
    }
}