package com.example.huangbaole.databindinglivedata.paging

import android.arch.paging.PageKeyedDataSource
import android.util.Log

class GankDataSource(val api: GankApi) : PageKeyedDataSource<Int, Gank>() {
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Gank>) {
        var call = api.loadAndroidList(1, 10)
        var body = call.execute().body()
        callback.onResult(body?.results!!, 0, 2)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Gank>) {
        var body = api.loadAndroidList(params.key).execute().body()
        callback.onResult(body?.results!!, params.key + 1)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Gank>) {
        Log.d("TAG", params.key.toString() + "")
        if (params.key - 1 <= 0) {
            return
        }
        var body = api.loadAndroidList(params.key).execute().body()
        callback.onResult(body?.results!!, params.key - 1)
    }
}