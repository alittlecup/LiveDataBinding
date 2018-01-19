package com.example.huangbaole.databindinglivedata.paging

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.PagedList

class GankViewModel() : ViewModel() {
    lateinit var items: LiveData<PagedList<Gank>>
    val respository: GankRepository = GankRepository()
    fun loadAndroidData() {
        items = respository.loadAndroidData()
    }
}