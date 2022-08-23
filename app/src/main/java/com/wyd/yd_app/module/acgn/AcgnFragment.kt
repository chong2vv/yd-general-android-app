package com.wyd.yd_app.module.acgn

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.wyd.yd_app.base.BaseFragment
import com.wyd.yd_app.base.list.XRecyclerView
import com.wyd.yd_app.base.list.base.BaseViewData
import com.wyd.yd_app.constant.PageName
import com.wyd.yd_app.databinding.FragmentAcgnBinding

/**
 * 二次元
 */
class AcgnFragment : BaseFragment<FragmentAcgnBinding>(FragmentAcgnBinding::inflate) {

    private val viewModel: AcgnViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        viewBinding.rvList.init(
            XRecyclerView.Config()
                .setViewModel(viewModel)
                .setPullRefreshEnable(false)
                .setPullUploadMoreEnable(false)
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
    }

    @PageName
    override fun getPageName() = PageName.ACGN

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        // 这里可以添加页面打点
    }
}