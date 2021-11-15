package com.gewudi.keyboard_android.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.gewudi.keyboard_android.databinding.ViewTitleValueBinding
import com.gewudi.keyboard_android.util.toVisibility

class TitleValueView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    val viewBinding = ViewTitleValueBinding.inflate(LayoutInflater.from(context), this, true)

    fun setTitileValue(title: String, value: String) {
        viewBinding.run {
            titleValueTitleView.text = title
            titleValueValueView.text = value
        }
    }

    fun setTitleStr(title: String) {
        viewBinding.run {
            titleValueTitleView.text = title
        }
    }

    fun setValueStr(value: String) {
        viewBinding.run {
            titleValueValueView.text = value
        }
    }


    fun setParameter(builder: TitleValueView.ParameterBuilder) {
        val parameter = builder.build()
        viewBinding.run {
            titleValueTitleView.text = parameter.title
            titleValueValueView.text = parameter.value
        }
    }

    data class Parameter(
        var value: String,
        var title: String
    )

    class ParameterBuilder {

        private var title = ""
        private var value = ""


        fun setValue(value: String): ParameterBuilder {
            this.value = value
            return this
        }

        fun setTitle(title: String): ParameterBuilder {
            this.title = title
            return this
        }

        fun build(): TitleValueView.Parameter {
            return TitleValueView.Parameter(value,title)
        }
    }
}