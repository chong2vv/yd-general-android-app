package com.wyd.yd_app.item

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wyd.yd_app.base.list.base.BaseItemViewDelegate
import com.wyd.yd_app.databinding.ItemUserListBinding

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