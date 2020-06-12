package com.imyyq.sample.app

import com.imyyq.mvvm.http.HttpRequest.getService
import com.imyyq.sample.data.Repository
import com.imyyq.sample.data.source.LocalDataSource
import com.imyyq.sample.data.source.http.HttpDataSourceImpl
import com.imyyq.sample.data.source.http.service.WanAndroidApiService
import com.imyyq.sample.data.source.local.LocalDataSourceImpl

/**
 * 注入全局的数据仓库，可以考虑使用Dagger2。（根据项目实际情况搭建，千万不要为了架构而架构）
 */
object Injection {
    fun provideDemoRepository(): Repository {
        //网络API服务
        val apiService =
            getService(WanAndroidApiService::class.java)
        //网络数据源
        val httpDataSource = HttpDataSourceImpl
        httpDataSource.wanAndroidApiService = apiService
        //本地数据源
        val localDataSource: LocalDataSource = LocalDataSourceImpl

        //两条分支组成一个数据仓库
        Repository.httpDataSource = httpDataSource
        Repository.localDataSource = localDataSource
        return Repository
    }
}