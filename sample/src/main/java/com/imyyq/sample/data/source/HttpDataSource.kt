package com.imyyq.sample.data.source

import com.haroldadmin.cnradapter.NetworkResponse
import com.imyyq.sample.entity.BaseEntity
import com.imyyq.sample.entity.FriendWebSiteEntity

interface HttpDataSource {
    // wanandroid 的开发 api 模拟登录 https://www.wanandroid.com/
    suspend fun login(userName: String, pwd: String): BaseEntity<List<FriendWebSiteEntity?>?>?
    suspend fun login2(userName: String, pwd: String): NetworkResponse<BaseEntity<List<FriendWebSiteEntity?>?>, BaseEntity<List<FriendWebSiteEntity?>?>>
}