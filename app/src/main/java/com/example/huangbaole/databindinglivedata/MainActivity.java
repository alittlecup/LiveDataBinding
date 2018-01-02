package com.example.huangbaole.databindinglivedata;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.databinding.OnRebindCallback;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import com.example.huangbaole.databindinglivedata.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mBinding;
     MainViewModel mainViewModel;
    String TAG="TAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainViewModel= ViewModelProviders.of(this, new ViewModelProvider.NewInstanceFactory()).get(MainViewModel.class);
        mBinding.setViewModel(mainViewModel);
        mBinding.setLifecycleOwner(this);
        mBinding.input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d(TAG, "beforeTextChanged: ");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "onTextChanged: ");
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s != null) {
                    Log.d("TAG", "afterTextChanged: " + s.toString());
                } else {
                    Log.d("TAG", "afterTextChanged: " + "null");
                }
                Log.d(TAG, "afterTextChanged: "+mainViewModel.input.getValue());
            }
        });
        mBinding.includeView.setLifecycleOwner(this);
        mBinding.includeView.setViewModel(mainViewModel);
        mBinding.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                Log.d(TAG, "onPropertyChanged: ");
            }
        });
        mBinding.addOnRebindCallback(new OnRebindCallback() {
            @Override
            public void onBound(ViewDataBinding binding) {
                super.onBound(binding);
            }
        });
    }
}
