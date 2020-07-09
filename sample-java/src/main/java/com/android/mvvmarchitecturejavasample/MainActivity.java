package com.android.mvvmarchitecturejavasample;

import com.android.mvvmarchitecturejavasample.databinding.ActivityMainBinding;
import com.imyyq.mvvm.BR;
import com.imyyq.mvvm.base.DataBindingBaseActivity;

public class MainActivity extends DataBindingBaseActivity<ActivityMainBinding, MainViewModel> {

    public MainActivity() {
        super(R.layout.activity_main, BR.viewModel);
    }
}
