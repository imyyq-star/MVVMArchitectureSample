package com.imyyq.sample.data.source

interface LocalDataSource {
    /**
     * 保存用户名
     */
    fun saveUserName(userName: String?)

    /**
     * 保存用户密码
     */
    fun savePassword(password: String?)

    /**
     * 获取用户名
     */
    val userName: String?

    /**
     * 获取用户密码
     */
    val password: String?
}