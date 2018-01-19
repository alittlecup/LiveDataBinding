package com.example.huangbaole.databindinglivedata.paging

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.huangbaole.databindinglivedata.databinding.ItemGankBinding

class GankViewHolder(view:View):RecyclerView.ViewHolder(view){
    val mBinding: ItemGankBinding
    init {
        mBinding=DataBindingUtil.bind<ItemGankBinding>(view)!!
    }
}