package com.example.huangbaole.databindinglivedata.paging

import android.arch.paging.DataSource

class GankDataSourceFactory : DataSource.Factory<Int, Gank> {
    override fun create(): DataSource<Int, Gank> {
        return GankDataSource(GankApi.create())
    }
}