package com.gewudi.keyboard_android.item

import android.content.Context
import android.content.res.Resources
import android.os.Build
import android.view.*
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.blankj.utilcode.util.ImageUtils
import com.gewudi.keyboard_android.base.list.base.BaseItemViewDelegate
import com.gewudi.keyboard_android.databinding.ItemHomeBinding
import com.gewudi.keyboard_android.util.setImageUrl
import java.net.URL
import android.graphics.Bitmap

import com.bumptech.glide.request.target.SimpleTarget

import com.bumptech.glide.Glide




const val STANDARD_SCALE = 1.1
const val SCALE = 4*1.0f /3

class HomeItemViewDelegate : BaseItemViewDelegate<HomeItemViewData, HomeItemViewDelegate.ViewHolder>() {


    override fun onCreateViewHolder(inflater: LayoutInflater, context: Context, parent: ViewGroup): ViewHolder {
        return ViewHolder(ItemHomeBinding.inflate(inflater, parent, false))
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onBindViewHolder(holder: ViewHolder, item: HomeItemViewData) {
        super.onBindViewHolder(holder, item)
        item.value.cover_image?.let { holder.viewBinding.cardImage.setImageUrl(it) }
        holder.viewBinding.cardTitle.text = item.value.title
        var layoutParams = holder.viewBinding.cardImage.layoutParams
        val wm = holder.viewBinding.cardImage.context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display: WindowMetrics = wm.currentWindowMetrics
        var itemWidth = (display.bounds.width() - 56)/2
        layoutParams.width = itemWidth

        var width: Int = holder.viewBinding.card.height
        var height: Int =  holder.viewBinding.card.height
//        height / width
//        println("width ======= "+ width)
        val position: Int = holder.absoluteAdapterPosition
        if (position == 1) {
            //采用1:1显示
            layoutParams.height = itemWidth
        } else {
            //采用3:4显示
            layoutParams.height = (itemWidth * SCALE).toInt()
        }
    }

    class ViewHolder(val viewBinding: ItemHomeBinding) : RecyclerView.ViewHolder(viewBinding.root) {

    }
}