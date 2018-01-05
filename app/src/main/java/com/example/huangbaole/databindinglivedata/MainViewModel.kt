package com.example.huangbaole.databindinglivedata

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.os.Handler
import java.util.*

class MainViewModel : ViewModel() {

    val input = MutableLiveData<String>()
    val include_string = MutableLiveData<String>()

    var commonString = "commonString"
    var observableString = ObservableField("ObservableString")
    internal var handler: Handler

    init {
        input.value = "test"
        include_string.value = "include_string"
        handler = Handler()
    }

    fun onClick() {
        val random = Random()
        input.value = random.nextInt(100).toString() + ""
        include_string.value = random.nextInt(100).toString() + ""
    }

    fun onAsyncClick() {
        val random = Random()

        handler.postDelayed({
            input.value = random.nextInt(100).toString() + "async"
            include_string.setValue(random.nextInt(100).toString() + "async")
        }, 5000)
    }

}
