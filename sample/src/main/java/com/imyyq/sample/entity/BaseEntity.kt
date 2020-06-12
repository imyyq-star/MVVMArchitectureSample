package com.imyyq.sample.entity

data class BaseEntity<T>(
    var data: T?,
    var errorCode: Int?,
    var errorMsg: String?
)