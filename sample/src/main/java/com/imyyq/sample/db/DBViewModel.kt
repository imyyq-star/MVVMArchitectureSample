package com.imyyq.sample.db

import android.app.Application
import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.imyyq.mvvm.base.BaseModel
import com.imyyq.mvvm.base.BaseViewModel
import com.imyyq.mvvm.room.RoomUtil
import com.imyyq.sample.data.source.local.AppDatabase
import com.imyyq.sample.entity.User
import kotlin.concurrent.thread

class DBViewModel(app: Application) : BaseViewModel<BaseModel>(app) {
    // room 版本升级
    private val migration: Migration = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            Log.i("DBViewModel", "commonLog - migrate: ")
            database.execSQL("alter table user add column `version2` TEXT")
        }
    }

    private val database = RoomUtil.getDB(AppDatabase::class.java, migrations = arrayOf(migration))

    val userLiveData: LiveData<String> = Transformations.map(
        database.getUserDao().getAllUser()
    ) { list ->
        val builder = StringBuilder()
        list.forEach {
            builder.append("${it.id}\t${it.name}\t${it.age}\t${it.version2}")
            builder.append("\n")
        }
        builder.toString()
    }

    val insert = View.OnClickListener {
        thread {
            val list = mutableListOf<User>()
            for (i in 0..5) {
                list.add(User(name = "name $i", age = i, version2 = "heihei $i"))
            }
            database.getUserDao().insert(list)
        }
    }
}