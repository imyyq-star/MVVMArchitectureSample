package com.android.mvvmarchitecturejavasample;

import android.os.Bundle;

import com.android.mvvmarchitecturejavasample.databinding.ActivityMainBinding;
import com.imyyq.mvvm.BR;
import com.imyyq.mvvm.base.BaseActivity;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    public MainActivity() {
        super(R.layout.activity_main, BR.viewModel);
    }
}
