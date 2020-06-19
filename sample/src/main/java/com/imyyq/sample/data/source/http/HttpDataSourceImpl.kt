package com.imyyq.sample.data.source.http

import com.imyyq.sample.data.source.HttpDataSource
import com.imyyq.sample.data.source.http.service.WanAndroidApiService
import com.imyyq.sample.entity.BaseEntity
import com.imyyq.sample.entity.FriendWebSiteEntity
import com.imyyq.sample.entity.handleException

object HttpDataSourceImpl : HttpDataSource {
    lateinit var wanAndroidApiService: WanAndroidApiService

    override suspend fun login(userName: String, pwd: String): BaseEntity<List<FriendWebSiteEntity?>?>? {
        return try {
            wanAndroidApiService.login(userName, pwd)
        } catch (e: Exception) {
            handleException(e)
        }
    }
}