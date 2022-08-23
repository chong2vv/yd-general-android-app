package com.wyd.yd_app.item

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.wyd.yd_app.R
import com.wyd.yd_app.base.list.base.BaseItemViewDelegate
import com.wyd.yd_app.constant.LoadMoreState
import com.wyd.yd_app.databinding.ViewRecyclerFooterBinding

class LoadMoreViewDelegate : BaseItemViewDelegate<LoadMoreViewData, LoadMoreViewDelegate.ViewHolder>() {

    override fun onCreateViewHolder(inflater: LayoutInflater, context: Context, parent: ViewGroup): ViewHolder {
        return ViewHolder(ViewRecyclerFooterBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, item: LoadMoreViewData) {
        super.onBindViewHolder(holder, item)
        holder.viewBinding.run {
            when (item.value) {
                LoadMoreState.GONE -> {
                    footerRoot.visibility = View.GONE
                }
                LoadMoreState.LOADING -> {
                    footerRoot.visibility = View.VISIBLE
                    tvLoadMoreState.setText(R.string.load_more_loading)
                }
                LoadMoreState.ERROR -> {
                    footerRoot.visibility = View.VISIBLE
                    tvLoadMoreState.setText(R.string.load_more_network_error)
                }
                LoadMoreState.NO_NETWORK -> {
                    footerRoot.visibility = View.VISIBLE
                    tvLoadMoreState.setText(R.string.load_more_no_network)
                }
                LoadMoreState.NO_MORE -> {
                    footerRoot.visibility = View.VISIBLE
                    tvLoadMoreState.setText(R.string.load_more_no_more)
                }
            }
        }
    }

    /**
     * 如果是StaggeredGridLayoutManager，加载更多应该展示成通栏样式
     */
    override fun onViewAttachedToWindow(holder: ViewHolder) {
        super.onViewAttachedToWindow(holder)
        val lp = holder.itemView.layoutParams
        if (lp is StaggeredGridLayoutManager.LayoutParams) {
            lp.isFullSpan = true
        }
    }

    class ViewHolder(val viewBinding: ViewRecyclerFooterBinding) : RecyclerView.ViewHolder(viewBinding.root) {

    }
}