package com.android.mvvmarchitecturejavasample;

import com.imyyq.mvvm.app.BaseApp;
import com.imyyq.mvvm.http.HttpRequest;

public class MyApplication extends BaseApp {
    @Override
    public void onCreate() {
        super.onCreate();
        HttpRequest.mDefaultBaseUrl = "https://www.wanandroid.com/";
    }
}
