package com.wyd.yd_app.item

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wyd.yd_app.base.list.base.BaseItemViewDelegate
import com.wyd.yd_app.databinding.ItemMineSettingBinding



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