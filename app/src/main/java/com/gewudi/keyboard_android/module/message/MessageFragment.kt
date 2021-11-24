package com.gewudi.keyboard_android.module.message

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.gewudi.keyboard_android.base.BaseFragment
import com.gewudi.keyboard_android.constant.EventName
import com.gewudi.keyboard_android.constant.PageName
import com.gewudi.keyboard_android.databinding.FragmentMessageBinding
import com.gewudi.keyboard_android.eventbus.XEventBus

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
        viewBinding.tvGold.setOnClickListener {
            XEventBus.post(EventName.REFRESH_HOME_LIST, "领现金页面通知首页刷新数据")
        }
    }

    @PageName
    override fun getPageName() = PageName.MESSAGE

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        // 这里可以添加页面打点
    }
}