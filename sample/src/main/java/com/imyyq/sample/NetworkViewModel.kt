package com.imyyq.sample

import android.app.Application
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewModelScope
import com.imyyq.mvvm.base.BaseViewModel
import com.imyyq.mvvm.http.HttpRequest
import com.imyyq.mvvm.utils.LogUtil
import com.imyyq.sample.data.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NetworkViewModel(app: Application) : BaseViewModel<Repository>(app) {
    val resultCode = ObservableField<String>()

    val openLog = View.OnClickListener {
        LogUtil.multiClickToOpenLog(it, 5)
    }

    val openChangeBaseUrl = View.OnClickListener {
        HttpRequest.multiClickToChangeBaseUrl(it, 5)
    }

    override fun onResume(owner: LifecycleOwner) {
        // 使用 vm 的协程，可以在界面销毁时自动取消该协程
        showLoadingDialog()
        LogUtil.i("NetworkViewModel", "commonLog - onResume: start")
        launch({
            delay(2000)
            mModel.login("userName", "pwd")
        },
            onSuccess = {
                LogUtil.i("NetworkViewModel", "commonLog - onResume: success")
            },
            onResult = {
                LogUtil.i("NetworkViewModel", "commonLog - onResult: ${it.size}")
                resultCode.set(it.size.toString())
            },
            onFailed = { code, msg ->
                LogUtil.i("NetworkViewModel", "commonLog - onFailed: $code, $msg")
            },
            onComplete = {
                dismissLoadingDialog()
            }
        )

        viewModelScope.launch {
            withContext(Dispatchers.Main) {
                launchFlow {
                    LogUtil.i("NetworkViewModel", "commonLog - onResume launchFlow: ${Thread.currentThread().name}")
                    return@launchFlow 100
                }
                .onStart {
                    LogUtil.i("NetworkViewModel", "commonLog - onResume onStart: ${Thread.currentThread().name}")
                }
                .flowOn(Dispatchers.IO)

                .onCompletion {
                    LogUtil.i("NetworkViewModel", "commonLog - onResume: onCompletion ${Thread.currentThread().name}")
                }.onEach {
                    LogUtil.i("NetworkViewModel", "commonLog - onResume: onEach $it ${Thread.currentThread().name}")
                }
                .flowOn(Dispatchers.Main)

                .collect {
                    LogUtil.i("NetworkViewModel", "commonLog - onResume: collect $it ${Thread.currentThread().name}")
                }
            }
        }
    }
}