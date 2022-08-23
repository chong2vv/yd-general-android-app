package com.wyd.yd_app.item

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wyd.yd_app.base.list.base.BaseItemViewDelegate
import com.wyd.yd_app.databinding.ItemUserUpdateBinding

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