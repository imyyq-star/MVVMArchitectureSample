package com.imyyq.sample.data.source.local

import com.imyyq.sample.data.source.LocalDataSource

object LocalDataSourceImpl : LocalDataSource {
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