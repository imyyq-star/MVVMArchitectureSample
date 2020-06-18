package com.imyyq.sample.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.imyyq.sample.entity.User

@Dao
interface UserDao {
    @Insert
    fun insert(list: List<User>)

    @Query("select * from user")
    fun getAllUser(): LiveData<List<User>>
}