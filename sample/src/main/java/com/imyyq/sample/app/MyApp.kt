package com.imyyq.sample.app

import android.util.Log
import com.imyyq.mvvm.app.AppStateTracker
import com.imyyq.mvvm.app.BaseApp
import com.imyyq.mvvm.http.HttpRequest

class MyApp : BaseApp() {
    override fun onCreate() {
        super.onCreate()
        // 要么继承 BaseApp，要么调用 init 方法
        // BaseApp.initApp(this)

        // 网络请求需设置 baseUrl
        HttpRequest.setHost("https://www.wanandroid.com/")

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