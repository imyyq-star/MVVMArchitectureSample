package com.android.mvvmarchitecturejavasample;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;

import com.imyyq.mvvm.base.BaseModel;
import com.imyyq.mvvm.base.BaseViewModel;

import org.jetbrains.annotations.NotNull;

public class TestViewModel extends BaseViewModel<BaseModel> {
    public TestViewModel(@NotNull Application app) {
        super(app);
    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
    }
}
