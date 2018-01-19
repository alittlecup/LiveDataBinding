package com.example.huangbaole.databindinglivedata

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.huangbaole.databindinglivedata.paging.PagingActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivty : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        data_live.setOnClickListener { startActivity(Intent(this@MainActivty, DataLiveActivity::class.java)) }
        paging_lib.setOnClickListener { startActivity(Intent(this, PagingActivity::class.java)) }
    }
}
