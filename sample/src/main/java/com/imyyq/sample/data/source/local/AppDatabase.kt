package com.imyyq.sample.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.imyyq.sample.entity.User

@Database(entities = [User::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getUserDao(): UserDao
}