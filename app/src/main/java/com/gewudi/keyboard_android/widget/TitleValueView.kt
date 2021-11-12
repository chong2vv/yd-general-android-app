package com.gewudi.keyboard_android.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.gewudi.keyboard_android.databinding.ViewTitleValueBinding

class TitleValueView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    val viewBinding = ViewTitleValueBinding.inflate(LayoutInflater.from(context), this, true)

}