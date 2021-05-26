package com.imyyq.sample.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TestEntity2(
    val age: Int,
    val name: String
) : Parcelable