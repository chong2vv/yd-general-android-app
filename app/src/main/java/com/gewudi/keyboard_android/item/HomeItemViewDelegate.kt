package com.gewudi.keyboard_android.item

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gewudi.keyboard_android.base.list.base.BaseItemViewDelegate
import com.gewudi.keyboard_android.databinding.ItemHomeBinding

class HomeItemViewDelegate : BaseItemViewDelegate<HomeItemViewData, HomeItemViewDelegate.ViewHolder>() {

    override fun onCreateViewHolder(inflater: LayoutInflater, context: Context, parent: ViewGroup): ViewHolder {
        return ViewHolder(ItemHomeBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, item: HomeItemViewData) {
        super.onBindViewHolder(holder, item)
//        holder.viewBinding.tvTest.text = item.value
    }

    class ViewHolder(val viewBinding: ItemHomeBinding) : RecyclerView.ViewHolder(viewBinding.root) {

    }
}