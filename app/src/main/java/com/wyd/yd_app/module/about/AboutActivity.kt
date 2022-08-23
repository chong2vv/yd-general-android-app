package com.wyd.yd_app.module.about

import android.os.Bundle
import com.wyd.yd_app.base.BaseActivity
import com.wyd.yd_app.constant.EventName
import com.wyd.yd_app.constant.PageName
import com.wyd.yd_app.databinding.ActivityAboutBinding
import com.wyd.yd_app.eventbus.XEventBus

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