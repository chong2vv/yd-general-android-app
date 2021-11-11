package com.gewudi.keyboard_android.item

import android.content.Context
import android.content.res.Resources
import android.os.Build
import android.view.*
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.gewudi.keyboard_android.base.list.base.BaseItemViewDelegate
import com.gewudi.keyboard_android.databinding.ItemHomeBinding
import com.gewudi.keyboard_android.util.setImageUrl
import java.net.URL

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
//        val wm = holder.viewBinding.cardImage.context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
//        val display: WindowMetrics = wm.currentWindowMetrics
//        var itemWidth = (display.bounds.width() - 56)/2
//        layoutParams.width = itemWidth.toInt()
//
//        val width: Int = holder.viewBinding.card.width
//        val height: Int =  holder.viewBinding.card.height
//        val scale = height / width
//        if (scale > STANDARD_SCALE) {
//            //采用3:4显示
//            layoutParams.height = (itemWidth * SCALE).toInt()
//        } else {
//            //采用1:1显示
//            layoutParams.height = itemWidth
//        }
//        holder.viewBinding.cardImage.layoutParams = layoutParams
    }

    class ViewHolder(val viewBinding: ItemHomeBinding) : RecyclerView.ViewHolder(viewBinding.root) {

    }
}