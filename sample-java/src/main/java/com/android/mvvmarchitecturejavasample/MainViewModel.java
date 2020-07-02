package com.android.mvvmarchitecturejavasample;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LifecycleOwner;

import com.android.mvvmarchitecturejavasample.data.WanAndroidApiService;
import com.imyyq.mvvm.base.BaseModel;
import com.imyyq.mvvm.base.BaseViewModel;
import com.imyyq.mvvm.http.HttpRequest;

import org.jetbrains.annotations.NotNull;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends BaseViewModel<BaseModel> {
    public ObservableField<String> result = new ObservableField<>();

    public MainViewModel(@NotNull Application app) {
        super(app);
    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        addSubscribe(HttpRequest.INSTANCE.getService(WanAndroidApiService.class).demoGet().
                subscribeOn(Schedulers.io())
                .map(demoEntity -> {
                    Log.i("MainViewModel", "commonLog - onResume: sleep");
                    Thread.sleep(2000);
                    return demoEntity;
                })
                .observeOn(AndroidSchedulers.mainThread()).subscribe(demoEntity -> {
            Log.i("MainViewModel", "commonLog - onResume: "+demoEntity);
            result.set(String.valueOf(demoEntity.getErrorCode()));
        }));
    }
}
