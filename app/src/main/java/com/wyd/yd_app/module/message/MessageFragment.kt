package com.wyd.yd_app.module.message

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.wyd.yd_app.base.BaseFragment
import com.wyd.yd_app.base.list.XRecyclerView
import com.wyd.yd_app.base.list.base.BaseViewData
import com.wyd.yd_app.constant.PageName
import com.wyd.yd_app.databinding.FragmentMessageBinding

/**
 * 领现金
 */
class MessageFragment : BaseFragment<FragmentMessageBinding>(FragmentMessageBinding::inflate) {

    private val viewModel: MessageViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        viewBinding.rvList.init(
            XRecyclerView.Config()
                .setViewModel(viewModel)
                .setOnItemClickListener(object : XRecyclerView.OnItemClickListener {
                    override fun onItemClick(parent: RecyclerView, view: View, viewData: BaseViewData<*>, position: Int, id: Long) {
                        Toast.makeText(context, "条目点击: ${viewData.value}", Toast.LENGTH_SHORT).show()
                    }
                })
        )
    }

    @PageName
    override fun getPageName() = PageName.MESSAGE

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        // 这里可以添加页面打点
    }
}