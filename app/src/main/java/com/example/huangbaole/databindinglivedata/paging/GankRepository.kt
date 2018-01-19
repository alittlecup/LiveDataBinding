package com.example.huangbaole.databindinglivedata.paging

import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import android.support.annotation.MainThread
import java.util.concurrent.Executors

class GankRepository {
    @MainThread
    fun loadAndroidData(): LiveData<PagedList<Gank>> {
        var gankDataSourceFactory = GankDataSourceFactory()
        var builder = LivePagedListBuilder(gankDataSourceFactory, 20)
                .setBackgroundThreadExecutor(Executors.newFixedThreadPool(5))
        return builder.build()
    }
}