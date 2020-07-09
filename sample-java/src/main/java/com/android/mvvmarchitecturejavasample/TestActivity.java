package com.android.mvvmarchitecturejavasample;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.android.mvvmarchitecturejavasample.databinding.ActivityTestBinding;
import com.imyyq.mvvm.base.ViewBindingBaseActivity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TestActivity extends ViewBindingBaseActivity<ActivityTestBinding, TestViewModel> {
    @NotNull
    @Override
    public ActivityTestBinding initBinding(@NotNull LayoutInflater inflater, @Nullable ViewGroup container) {
        return ActivityTestBinding.inflate(getLayoutInflater());
    }
}
