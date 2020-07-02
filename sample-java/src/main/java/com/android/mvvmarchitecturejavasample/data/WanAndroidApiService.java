package com.android.mvvmarchitecturejavasample.data;

import com.android.mvvmarchitecturejavasample.entity.DemoEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface WanAndroidApiService {
    @GET("wxarticle/chapters/json")
    Observable<DemoEntity> demoGet();
}
