package com.imyyq.sample.data

import com.haroldadmin.cnradapter.NetworkResponse
import com.imyyq.mvvm.base.BaseModel
import com.imyyq.sample.data.source.HttpDataSource
import com.imyyq.sample.data.source.LocalDataSource
import com.imyyq.sample.entity.BaseEntity
import com.imyyq.sample.entity.FriendWebSiteEntity

/**
 * 仓库应该是单例的，持有各种数据源
 */
object Repository :
    BaseModel(), HttpDataSource, LocalDataSource {
    lateinit var httpDataSource: HttpDataSource
    lateinit var localDataSource: LocalDataSource

    override suspend fun login(userName: String, pwd: String): BaseEntity<List<FriendWebSiteEntity?>?>? {
        return httpDataSource.login(userName, pwd)
    }

    override suspend fun login2(
        userName: String,
        pwd: String
    ): NetworkResponse<BaseEntity<List<FriendWebSiteEntity?>?>, BaseEntity<List<FriendWebSiteEntity?>?>> {
        return httpDataSource.login2(userName, pwd)
    }

    override fun saveUserName(userName: String?) {
        TODO("Not yet implemented")
    }

    override fun savePassword(password: String?) {
        TODO("Not yet implemented")
    }

    override val userName: String?
        get() = TODO("Not yet implemented")
    override val password: String?
        get() = TODO("Not yet implemented")
}