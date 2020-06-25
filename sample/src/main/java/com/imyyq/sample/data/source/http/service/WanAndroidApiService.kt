package com.imyyq.sample.data.source.http.service

import com.haroldadmin.cnradapter.NetworkResponse
import com.imyyq.sample.entity.BaseEntity
import com.imyyq.sample.entity.FriendWebSiteEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface WanAndroidApiService {
    // wanandroid 的开发 api 模拟登录 https://www.wanandroid.com/
    @GET("friend/json")
    suspend fun login(
        @Query("userName") userName: String,
        @Query("pwd") pwd: String
    ): BaseEntity<List<FriendWebSiteEntity?>?>?

    @GET("friend/json2")
    suspend fun login2(
        @Query("userName") userName: String,
        @Query("pwd") pwd: String
    ): NetworkResponse<BaseEntity<List<FriendWebSiteEntity?>?>, BaseEntity<List<FriendWebSiteEntity?>?>>
}