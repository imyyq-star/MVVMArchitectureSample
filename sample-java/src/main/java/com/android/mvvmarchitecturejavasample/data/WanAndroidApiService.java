package com.android.mvvmarchitecturejavasample.data;

import com.android.mvvmarchitecturejavasample.entity.BaseEntity;
import com.android.mvvmarchitecturejavasample.entity.DemoEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface WanAndroidApiService {
    @GET("wxarticle/chapters/json")
    Observable<BaseEntity<List<DemoEntity>>> demoGet();
    @GET("https://www.google.com")
    Call<BaseEntity<List<DemoEntity>>> demoGet2();
}
