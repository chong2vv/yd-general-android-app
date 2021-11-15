package com.gewudi.keyboard_android.item

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gewudi.keyboard_android.R
import com.gewudi.keyboard_android.base.list.base.BaseItemViewDelegate
import com.gewudi.keyboard_android.databinding.ItemMineSettingBinding



class MineSettingItemViewDelegate : BaseItemViewDelegate<MineSettingItemViewData, MineSettingItemViewDelegate.ViewHolder>() {

    override fun onCreateViewHolder(inflater: LayoutInflater, context: Context, parent: ViewGroup): ViewHolder {
        return ViewHolder(ItemMineSettingBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, item: MineSettingItemViewData) {
        super.onBindViewHolder(holder, item)
//        holder.viewBinding.tvTest.text = item.value.firstName + item.value.lastName
        //        item.value.iconName?.let { holder.viewBinding.mineSetImage.setImageResource(it) }
        item.value.title?.let { holder.viewBinding.mineSetTitle.text = it }
    }

    class ViewHolder(val viewBinding: ItemMineSettingBinding) : RecyclerView.ViewHolder(viewBinding.root) {

    }
}