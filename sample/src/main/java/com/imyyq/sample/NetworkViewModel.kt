package com.imyyq.sample

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LifecycleOwner
import com.imyyq.mvvm.base.BaseViewModel
import com.imyyq.sample.data.Repository
import kotlinx.coroutines.delay

class NetworkViewModel(app: Application, model: Repository) : BaseViewModel<Repository>(app, model) {
    val resultCode = ObservableField<String>()

    override fun onResume(owner: LifecycleOwner) {
        // 使用 vm 的协程，可以在界面销毁时自动取消该协程
        showLoadingDialog()
        Log.i("NetworkViewModel", "commonLog - onResume: start")
        launch({
            delay(2000)
            mModel.login("userName", "pwd")
        },
            onSuccess = {
                Log.i("NetworkViewModel", "commonLog - onResume: success")
            },
            onResult = {
                Log.i("NetworkViewModel", "commonLog - onResult: ${it.size}")
                resultCode.set(it.size.toString())
            },
            onFailed = { code, msg ->
                Log.i("NetworkViewModel", "commonLog - onFailed: $code, $msg")
            },
            onComplete = {
                dismissDialog()
            }
        )
    }
}