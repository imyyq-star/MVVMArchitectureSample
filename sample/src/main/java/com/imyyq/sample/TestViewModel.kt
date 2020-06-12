package com.imyyq.sample

import android.app.Application
import android.util.Log
import com.imyyq.mvvm.base.BaseModel
import com.imyyq.mvvm.base.BaseViewModel

class TestViewModel(app: Application) : BaseViewModel<BaseModel>(app) {
    fun test() {
        Log.i("TestViewModel", "commonLog - test: ")
    }
}