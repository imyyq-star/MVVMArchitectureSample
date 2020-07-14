package com.imyyq.sample.data.source.http

import com.imyyq.mvvm.http.HttpRequest
import com.imyyq.sample.data.source.HttpDataSource
import com.imyyq.sample.data.source.http.service.WanAndroidApiService
import com.imyyq.sample.entity.BaseEntity
import com.imyyq.sample.entity.FriendWebSiteEntity

object HttpDataSourceImpl : HttpDataSource {
    private var wanAndroidApiService = HttpRequest.getService(WanAndroidApiService::class.java)

    override suspend fun login(userName: String, pwd: String): BaseEntity<List<FriendWebSiteEntity?>?>? {
        return wanAndroidApiService.login(userName, pwd)
    }
}