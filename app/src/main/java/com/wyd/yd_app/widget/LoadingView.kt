package com.wyd.yd_app.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.wyd.yd_app.R
import com.wyd.yd_app.databinding.ViewLoadingBinding

/**
 *  加载控件
 */
class LoadingView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    val viewBinding = ViewLoadingBinding.inflate(LayoutInflater.from(context), this, true).apply {
        viewLoading.setViewColor(resources.getColor(R.color.theme_color))
    }

    override fun setVisibility(visibility: Int) {
        super.setVisibility(visibility)
        if (visibility == View.VISIBLE) {
            viewBinding.viewLoading.startAnim()
        } else {
            viewBinding.viewLoading.stopAnim()
        }
    }

    override fun onDetachedFromWindow() {
        viewBinding.viewLoading.stopAnim()
        super.onDetachedFromWindow()
    }
}