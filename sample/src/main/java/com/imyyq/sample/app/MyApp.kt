package com.imyyq.sample.app

import com.imyyq.mvvm.app.AppStateTracker
import com.imyyq.mvvm.app.BaseApp
import com.imyyq.mvvm.app.GlobalConfig
import com.imyyq.mvvm.http.HttpRequest
import com.imyyq.mvvm.utils.LogUtil
import com.imyyq.sample.R
import com.imyyq.sample.loadsir.callback.EmptyCallback
import com.imyyq.sample.loadsir.callback.ErrorCallback
import com.imyyq.sample.loadsir.callback.LoadingCallback

class MyApp : BaseApp() {
    override fun onCreate() {
        super.onCreate()
        // 要么继承 BaseApp，要么调用 init 方法，如果没有自己的 application，则可直接使用 BaseApp
        // BaseApp.initApp(this)

        // 网络请求需设置 baseUrl，更多使用详见该类方法
        HttpRequest.mDefaultBaseUrl = "https://www.wanandroid.com/"

        // 初始化 LoadSir，内嵌加载中第三方库，框架对其进行了二次封装
        GlobalConfig.initLoadSir(
            LoadingCallback::class.java,
            EmptyCallback::class.java,
            ErrorCallback::class.java
        )

        // 是否支持点击事件间隔一定时间，可局部设置
        GlobalConfig.Click.gIsClickInterval = true
        // 设定间隔时间，毫秒为单位，默认是 800 毫秒，可局部设置
        GlobalConfig.Click.gClickIntervalMilliseconds = 700

        // 设置为 true 才可以使用框架的 AppActivityManager 类
        GlobalConfig.gIsNeedActivityManager = true
        // 开启动态修改 BaseURL 功能，配合 HttpRequest.multiClickToChangeBaseUrl 方法使用
        GlobalConfig.gIsNeedChangeBaseUrl = true
        // 开启侧滑返回功能，可局部设置，需 activity 的主题的 android:windowIsTranslucent 为 true，即透明
        GlobalConfig.gIsSupportSwipe = true

        // viewModel 是否需要调用 startXxxx 等方法，可局部设置
        GlobalConfig.StartAndFinish.gIsViewModelNeedStartAndFinish = true
        GlobalConfig.StartAndFinish.gIsViewModelNeedStartForResult = true

        // 加载中对话框相关的配置，可局部设置
        GlobalConfig.LoadingDialog.gIsNeedLoadingDialog = true
        // 是否开启取消对话框后，同步取消耗时任务
        GlobalConfig.LoadingDialog.gIsCancelConsumingTaskWhenLoadingDialogCanceled = true
        // 对话框是否可按返回键取消
        GlobalConfig.LoadingDialog.gLoadingDialogCancelable = true
        // 对话框是否可点击外部区域取消
        GlobalConfig.LoadingDialog.gLoadingDialogCanceledOnTouchOutside = true
//        GlobalConfig.gLoadingDialogLayout = true
//        GlobalConfig.gLoadingDialogLayoutMsgId = true
        // beta 默认是保存 log 到本地的，如果不需要可以设置为 false
        GlobalConfig.gIsBetaSaveLog = true

        // 声明全局的图片加载占位图和错误图，可局部在 xml 中设置
        GlobalConfig.ImageView.placeholderRes = R.drawable.ic_launcher_background
        GlobalConfig.ImageView.errorRes = R.drawable.ic_launcher_background

        // 可追踪应用的状态是在前台还是后台，注意：锁屏也是后台。
        AppStateTracker.track(object : AppStateTracker.AppStateChangeListener {
            override fun appTurnIntoForeground() {
                LogUtil.i("MyApp", "commonLog - appTurnIntoForeground: ")
            }

            override fun appTurnIntoBackground() {
                LogUtil.i("MyApp", "commonLog - appTurnIntoBackground: ")
            }
        })
    }
}