package com.gewudi.keyboard_android.item

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gewudi.keyboard_android.base.list.base.BaseItemViewDelegate
import com.gewudi.keyboard_android.databinding.ItemUserListBinding

class UserListItemViewDelegate : BaseItemViewDelegate<UserListItemViewData, UserListItemViewDelegate.ViewHolder>() {

    override fun onCreateViewHolder(inflater: LayoutInflater, context: Context, parent: ViewGroup): ViewHolder {
        return ViewHolder(ItemUserListBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, item: UserListItemViewData) {
        super.onBindViewHolder(holder, item)

    }

    class ViewHolder(val viewBinding: ItemUserListBinding) : RecyclerView.ViewHolder(viewBinding.root) {

    }
}