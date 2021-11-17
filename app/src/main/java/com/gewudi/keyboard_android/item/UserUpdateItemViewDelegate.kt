package com.gewudi.keyboard_android.item

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gewudi.keyboard_android.base.list.base.BaseItemViewDelegate
import com.gewudi.keyboard_android.databinding.ItemUserUpdateBinding

class UserUpdateItemViewDelegate : BaseItemViewDelegate<UserUpdateItemViewData, UserUpdateItemViewDelegate.ViewHolder>() {

    override fun onCreateViewHolder(inflater: LayoutInflater, context: Context, parent: ViewGroup): ViewHolder {
        return ViewHolder(ItemUserUpdateBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, item: UserUpdateItemViewData) {
        super.onBindViewHolder(holder, item)
        holder.run {
            viewBinding.userUpdateSetTitle.text = item.value.title
            viewBinding.userUpdateSetValue.text = item.value.value
        }
    }

    class ViewHolder(val viewBinding: ItemUserUpdateBinding) : RecyclerView.ViewHolder(viewBinding.root) {

    }
}