package com.example.huangbaole.databindinglivedata;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;

import java.util.Random;

public class MainViewModel extends ViewModel {

    public final MutableLiveData<String> input = new MutableLiveData<>();
    public final MutableLiveData<String> string = new MutableLiveData<>();
    Handler handler;

    public MainViewModel() {
        input.setValue("test");
        string.setValue("string");
        handler = new Handler();
    }

    public void onClick() {
        Random random = new Random();
        input.setValue(random.nextInt(100) + "");
    }

    public void onAsyncClick() {
        final Random random = new Random();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                input.setValue(random.nextInt(100) + "async");
            }
        }, 5000);
    }


}
