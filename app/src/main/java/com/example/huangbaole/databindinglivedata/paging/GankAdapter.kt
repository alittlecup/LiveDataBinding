package com.example.huangbaole.databindinglivedata.paging

import android.arch.paging.PagedListAdapter
import android.support.v7.recyclerview.extensions.DiffCallback
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.huangbaole.databindinglivedata.R

class GankAdapter : PagedListAdapter<Gank, GankViewHolder>(diffCallback) {
    companion object {
        val diffCallback = object : DiffCallback<Gank>() {
            override fun areContentsTheSame(oldItem: Gank, newItem: Gank): Boolean {
                return oldItem == newItem;
            }

            override fun areItemsTheSame(oldItem: Gank, newItem: Gank): Boolean {
                return oldItem._id == newItem._id
            }

        }
    }

    override fun onBindViewHolder(holder: GankViewHolder?, position: Int) {
        var item = getItem(position)
        with(holder?.mBinding!!) {
            title.text = item?.desc
            time.text = item?.publishedAt
            actor.text = item?.who
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): GankViewHolder {
        return GankViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_gank, parent, false))
    }
}



