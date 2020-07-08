package com.android.mvvmarchitecturejavasample;

import android.app.Application;
import com.imyyq.mvvm.utils.LogUtil;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LifecycleOwner;

import com.android.mvvmarchitecturejavasample.data.WanAndroidApiService;
import com.android.mvvmarchitecturejavasample.entity.DemoEntity;
import com.imyyq.mvvm.base.BaseModel;
import com.imyyq.mvvm.base.BaseViewModel;
import com.imyyq.mvvm.http.CommonObserver;
import com.imyyq.mvvm.http.HttpRequest;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends BaseViewModel<BaseModel> {
    public ObservableField<String> result = new ObservableField<>();

    public MainViewModel(@NotNull Application app) {
        super(app);
    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        // 使用 Rx 示例
        HttpRequest.getService(WanAndroidApiService.class).demoGet().
                subscribeOn(Schedulers.io())
                // 只有添加了这一句，才可以在页面销毁时取消请求
                .doOnSubscribe(this::addSubscribe)
                .map(demoEntity -> {
                    LogUtil.i("MainViewModel", "commonLog - onResume: sleep");
                    Thread.sleep(4000);
                    return demoEntity;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CommonObserver<List<DemoEntity>>() {
                    @Override
                    public void onStart() {
                    }

                    @Override
                    public void onSuccess() {
                        super.onSuccess();
                    }

                    @Override
                    public void onFailed(int code, @Nullable String msg) {
                        super.onFailed(code, msg);
                    }

                    @Override
                    public void onResult(List<DemoEntity> result) {
                        LogUtil.i("MainViewModel", "commonLog - onResume: " + mBaseResult);
                        MainViewModel.this.result.set(String.valueOf(mBaseResult.code()));
                    }

                    @Override
                    public void onComplete() {
                        LogUtil.i("MainViewModel", "onComplete: ");
                    }
                });


        // 原生 Retrofit 请求，只有 addSubscribe 了才可以在界面销毁时取消
        addCall(HttpRequest.request(HttpRequest.getService(WanAndroidApiService.class).demoGet2(),
                new CommonObserver<List<DemoEntity>>() {
                    @Override
                    public void onStart() {
                    }

                    @Override
                    public void onSuccess() {
                        super.onSuccess();
                    }

                    @Override
                    public void onFailed(int code, @Nullable String msg) {
                        super.onFailed(code, msg);
                    }

                    @Override
                    public void onResult(List<DemoEntity> result) {
                        LogUtil.i("MainViewModel", "commonLog - onResume: " + mBaseResult);
                        MainViewModel.this.result.set(String.valueOf(mBaseResult.code()));
                    }

                    @Override
                    public void onComplete() {
                        LogUtil.i("MainViewModel", "onComplete: ");
                    }
                }));
    }
}
