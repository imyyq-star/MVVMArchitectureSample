package com.imyyq.sample.data.source

import com.imyyq.sample.entity.BaseEntity
import com.imyyq.sample.entity.FriendWebSiteEntity

interface HttpDataSource {
    // wanandroid 的开发 api 模拟登录 https://www.wanandroid.com/
    suspend fun login(userName: String, pwd: String): BaseEntity<List<FriendWebSiteEntity?>?>?
}