package com.imyyq.sample.app

import android.util.Log
import com.imyyq.mvvm.app.AppStateTracker
import com.imyyq.mvvm.app.BaseApp
import com.imyyq.mvvm.app.GlobalConfig
import com.imyyq.mvvm.http.HttpRequest
import com.imyyq.sample.loadsir.callback.EmptyCallback
import com.imyyq.sample.loadsir.callback.ErrorCallback
import com.imyyq.sample.loadsir.callback.LoadingCallback

class MyApp : BaseApp() {
    override fun onCreate() {
        super.onCreate()
        // 要么继承 BaseApp，要么调用 init 方法
        // BaseApp.initApp(this)

        // 网络请求需设置 baseUrl
        HttpRequest.mDefaultBaseUrl = "https://www.wanandroid.com/"

        // 初始化 LoadSir
        GlobalConfig.initLoadSir(
            LoadingCallback::class.java,
            EmptyCallback::class.java,
            ErrorCallback::class.java
        )

        GlobalConfig.isViewModelNeedStartAndFinish = true
        GlobalConfig.isNeedLoadingDialog = true

        // 可追踪应用的是在前台还是后台
        AppStateTracker.track(object : AppStateTracker.AppStateChangeListener {
            override fun appTurnIntoForeground() {
                Log.i("MyApp", "commonLog - appTurnIntoForeground: ")
            }

            override fun appTurnIntoBackground() {
                Log.i("MyApp", "commonLog - appTurnIntoBackground: ")
            }
        })
    }
}