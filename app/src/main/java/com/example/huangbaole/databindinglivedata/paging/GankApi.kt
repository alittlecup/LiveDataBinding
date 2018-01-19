package com.example.huangbaole.databindinglivedata.paging

import android.util.Log
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface GankApi {
    @GET("{size}/{index}")
    fun loadAndroidList(@Path("index") index:Int, @Path("size") size: Int=10): Call<GankResponse<MutableList<Gank>>>

    companion object {
        val url = "http://gank.io/api/data/Android/"
        fun create() = create(HttpUrl.parse(url)!!)
        fun create(url: HttpUrl): GankApi {
            val logger = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
                Log.d("Http:", it)
            })
            val client = OkHttpClient.Builder().addInterceptor(logger).build()
            return Retrofit.Builder()
                    .baseUrl(url)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(GankApi::class.java)
        }
    }
}