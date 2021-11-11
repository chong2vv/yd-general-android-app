package com.gewudi.keyboard_android.module.about

import android.os.Bundle
import com.gewudi.keyboard_android.base.BaseActivity
import com.gewudi.keyboard_android.constant.EventName
import com.gewudi.keyboard_android.constant.PageName
import com.gewudi.keyboard_android.databinding.ActivityAboutBinding
import com.gewudi.keyboard_android.eventbus.XEventBus

class AboutActivity : BaseActivity<ActivityAboutBinding>(ActivityAboutBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        viewBinding.tvAbout.setOnClickListener {
            XEventBus.post(EventName.TEST, "来自关于页面的消息")
        }
    }

    @PageName
    override fun getPageName() = PageName.ABOUT
}