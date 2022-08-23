package com.wyd.yd_app.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import androidx.viewbinding.ViewBinding
import com.blankj.utilcode.util.KeyboardUtils
import com.wyd.yd_app.R
import com.gyf.immersionbar.ktx.immersionBar
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import me.imid.swipebacklayout.lib.app.SwipeBackActivity

/**
 * Activity基类
 */
abstract class BaseActivity<T : ViewBinding>(val inflater: (inflater: LayoutInflater) -> T) : SwipeBackActivity(), IGetPageName {

    protected lateinit var viewBinding: T
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = inflater(layoutInflater)
        setContentView(viewBinding.root)
        setSwipeBackEnable(swipeBackEnable())
    }

    override fun onStart() {
        super.onStart()
        // 这里可以添加页面打点
    }

    override fun onStop() {
        super.onStop()
        // 这里可以添加页面打点
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }

    /**
     * 状态栏导航栏初始化
     */
    open fun initSystemBar() {
        immersionBar {
            transparentStatusBar()
            statusBarDarkFont(true)
            navigationBarColor(R.color.white)
            navigationBarDarkIcon(true)
        }
    }

    /**
     * 默认开启左滑返回,如果需要禁用,请重写此方法
     */
    protected open fun swipeBackEnable() = true

    /**
     * 添加Disposable
     */
    protected fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (ev?.action == MotionEvent.ACTION_DOWN) {
            var v: View? = currentFocus
            v?.let {
                if (isShouldHideKeyboard(v, ev)) {
                    KeyboardUtils.hideSoftInput(this)
                }
            }
        }
        return super.dispatchTouchEvent(ev)
    }

    private fun isShouldHideKeyboard(v:View, event: MotionEvent): Boolean {
        if (v is EditText) {
            val l = intArrayOf(0,0)
            v.getLocationOnScreen(l)
            val left = l[0]
            val top = l[1]
            val bottom = top + v.height
            val right = left + v.width
            return !(event.rawX > left && event.rawX < right && event.rawY > top && event.rawY < bottom)
        }
        return false
    }

}