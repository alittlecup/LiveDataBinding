package com.example.huangbaole.databindinglivedata

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import com.example.huangbaole.databindinglivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mBinding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    internal var TAG = "TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)!!
        mainViewModel = ViewModelProviders.of(this, ViewModelProvider.NewInstanceFactory()).get(MainViewModel::class.java)
        mBinding.viewModel = mainViewModel
        mBinding.setLifecycleOwner(this)
        mBinding.input.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                Log.d(TAG, "beforeTextChanged: ")
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                Log.d(TAG, "onTextChanged: ")
            }

            override fun afterTextChanged(s: Editable?) {
                if (s != null) {
                    Log.d("TAG", "afterTextChanged: " + s.toString())
                } else {
                    Log.d("TAG", "afterTextChanged: " + "null")
                }
                Log.d(TAG, "afterTextChanged: " + mainViewModel.input.value!!)
            }
        })
        mBinding.includeView?.setLifecycleOwner(this)
        mBinding.includeView?.setViewModel(mainViewModel)
    }
}
