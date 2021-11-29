package com.gewudi.keyboard_android.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.gewudi.keyboard_android.constant.MessageType
import com.gewudi.keyboard_android.databinding.ViewImageTagBinding
import com.gewudi.keyboard_android.databinding.ViewTitleValueBinding
import com.gewudi.keyboard_android.util.setImageUrl

/**
 * @author wangyuandong
 * @date  2021/11/25
 */
class ImageTagView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    val viewBinding = ViewImageTagBinding.inflate(LayoutInflater.from(context), this, true)


    fun setMessageImageWithTag(imageUrl: String, type: Int) {
        viewBinding.run {
            userFaceImage.setImageUrl(imageUrl)
            when(type) {
                MessageType.MESSAGE_TYPE_LIKE ->{

                }
                MessageType.MESSAGE_TYPE_COMMENT ->{

                }
            }
        }
    }


}