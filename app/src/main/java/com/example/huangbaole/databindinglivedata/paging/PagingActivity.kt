package com.example.huangbaole.databindinglivedata.paging

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.arch.paging.PagedList
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.huangbaole.databindinglivedata.R
import kotlinx.android.synthetic.main.activity_paging.*

class PagingActivity : AppCompatActivity() {
    lateinit var mViewModel: GankViewModel
    lateinit var adapter: GankAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paging)
        initRecyclerView()
        initViewModel()
    }

    private fun initViewModel() {
        mViewModel = ViewModelProviders.of(this).get(GankViewModel::class.java)
        mViewModel.loadAndroidData()
        mViewModel.items.observe(this, Observer<PagedList<Gank>> { t -> adapter.setList(t) })

    }

    private fun initRecyclerView() {
        adapter = GankAdapter()
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = adapter
    }
}
