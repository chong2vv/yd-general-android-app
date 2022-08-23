package com.wyd.yd_app.module.main

import android.os.Bundle
import androidx.activity.viewModels
import com.wyd.yd_app.R
import com.wyd.yd_app.base.BaseActivity
import com.wyd.yd_app.bean.Tab
import com.wyd.yd_app.constant.PageName
import com.wyd.yd_app.constant.TabId
import com.wyd.yd_app.databinding.ActivityMainBinding
import com.wyd.yd_app.module.acgn.AcgnFragment
import com.wyd.yd_app.module.message.MessageFragment
import com.wyd.yd_app.module.home.HomeFragment
import com.wyd.yd_app.module.mine.MineFragment
import com.wyd.yd_app.module.smallvideo.SmallVideoFragment
import com.wyd.yd_app.widget.NavigationView
import com.wyd.yd_app.widget.TabIndicatorView
import com.gyf.immersionbar.ktx.immersionBar

/**
 * 首页
 */
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private val viewModel: MainViewModel by viewModels()

    // 当前选中的底栏ID
    @TabId
    private var currentTabId = TabId.HOME

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initSystemBar()
        updateTitle()
        initTabs()
    }

    @PageName
    override fun getPageName() = PageName.MAIN

    /**
     * 禁用左滑返回
     */
    override fun swipeBackEnable() = false

    /**
     * 状态栏导航栏初始化
     */
    override fun initSystemBar() {
        immersionBar {
            transparentStatusBar()
            statusBarDarkFont(true)
            navigationBarColor(R.color.white)
            navigationBarDarkIcon(true)
        }
    }

    /**
     * 初始化底栏
     */
    private fun initTabs() {
        val tabs = listOf(
            Tab(TabId.HOME, getString(R.string.page_home), R.drawable.selector_btn_home, HomeFragment::class),
            Tab(TabId.SMALL_VIDEO, getString(R.string.page_small_video), R.drawable.selector_btn_small_video, SmallVideoFragment::class),
            Tab(TabId.ACGN, getString(R.string.page_acgn), R.drawable.selector_btn_acgn, AcgnFragment::class),
            Tab(TabId.MESSAGE, getString(R.string.page_message), R.drawable.selector_btn_gold, MessageFragment::class),
            Tab(TabId.MINE, getString(R.string.page_mine), R.drawable.selector_btn_mine, MineFragment::class)
        )

        viewBinding.fragmentTabHost.run {
            // 调用setup()方法，设置FragmentManager，以及指定用于装载Fragment的布局容器
            setup(this@MainActivity, supportFragmentManager, viewBinding.fragmentContainer.id)
            tabs.forEach {
                val (id, title, icon, fragmentClz) = it
                val tabSpec = newTabSpec(id).apply {
                    setIndicator(TabIndicatorView(this@MainActivity).apply {
                        viewBinding.tabIcon.setImageResource(icon)
                        viewBinding.tabTitle.text = title
                    })
                }
                addTab(tabSpec, fragmentClz.java, null)
            }

            setOnTabChangedListener { tabId ->
                currentTabId = tabId
                updateTitle()
            }
        }
    }

    /**
     * 更新标题
     */
    private fun updateTitle() {
        val title = when (currentTabId) {
            TabId.HOME -> getString(R.string.page_home)
            TabId.SMALL_VIDEO -> getString(R.string.page_small_video)
            TabId.ACGN -> getString(R.string.page_acgn)
            TabId.MESSAGE -> getString(R.string.page_message)
            TabId.MINE -> getString(R.string.page_mine)
            else -> ""
        }

        viewBinding.navigationBar.setParameter(
            NavigationView.ParameterBuilder()
                .setShowBack(false)
                .setShowTitle(true)
                .setTitle(title)
        )
    }

    /**
     * 设置当前选中的TAB
     */
    private fun setCurrentTab(@TabId tabID: String) {
        viewBinding.fragmentTabHost.setCurrentTabByTag(tabID)
    }

}