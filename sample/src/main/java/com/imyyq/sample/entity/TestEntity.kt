package com.imyyq.sample.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TestEntity(
    val age: Int,
    val name: String
) : Parcelable