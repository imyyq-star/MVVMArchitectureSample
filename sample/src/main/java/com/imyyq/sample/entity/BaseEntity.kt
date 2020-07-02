package com.imyyq.sample.entity

import com.imyyq.mvvm.base.IBaseResponse

data class BaseEntity<T>(
    var data: T?,
    var errorCode: Int?,
    var errorMsg: String?
) : IBaseResponse<T> {
    override fun code() = errorCode

    override fun msg() = errorMsg

    override fun data() = data

    override fun isSuccess() = errorCode == 0
}