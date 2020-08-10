package com.imyyq.sample.data.source.http.service

import com.imyyq.sample.entity.BaseEntity
import com.imyyq.sample.entity.DemoEntity
import com.imyyq.sample.entity.FriendWebSiteEntity
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WanAndroidApiService {
    // wanandroid 的开发 api 模拟登录 https://www.wanandroid.com/
    @GET("friend/json")
    suspend fun login(
        @Query("userName") userName: String,
        @Query("pwd") pwd: String
    ): BaseEntity<List<FriendWebSiteEntity?>?>?

    @GET("https://github.com/")
    fun google(
    ): Call<ResponseBody?>?

    @GET("wxarticle/chapters/json")
    fun demoGet(): Observable<BaseEntity<List<DemoEntity?>?>?>

}