package com.imyyq.sample

import android.app.Application
import com.imyyq.mvvm.base.BaseModel
import com.imyyq.mvvm.base.BaseViewModel
import com.imyyq.mvvm.utils.LogUtil

class TestViewModel(app: Application) : BaseViewModel<BaseModel>(app) {
    fun test() {
        LogUtil.i("TestViewModel", "commonLog - test: ")
    }
}