package com.android.mvvmarchitecturejavasample;

import androidx.lifecycle.Observer;

import com.android.mvvmarchitecturejavasample.databinding.ActivityMainBinding;
import com.imyyq.mvvm.BR;
import com.imyyq.mvvm.base.DataBindingBaseActivity;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends DataBindingBaseActivity<ActivityMainBinding, MainViewModel> {

    public MainActivity() {
        super(R.layout.activity_main, BR.viewModel);
    }

    @Override
    public void initData() {
        super.initData();
        observe(mViewModel.liveData, this::onChanged);
    }

    public Unit onChanged(String s) {
        return null;
    }
}
