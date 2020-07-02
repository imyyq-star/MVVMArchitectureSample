package com.android.mvvmarchitecturejavasample;

import android.os.Bundle;

import com.android.mvvmarchitecturejavasample.databinding.ActivityTestBinding;
import com.imyyq.mvvm.BR;
import com.imyyq.mvvm.base.BaseActivity;

public class TestActivity extends BaseActivity<ActivityTestBinding, TestViewModel> {

    public TestActivity() {
        super(R.layout.activity_test, BR.viewModel);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
