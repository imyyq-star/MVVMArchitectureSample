package com.imyyq.sample

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.viewModelScope
import com.imyyq.mvvm.base.BaseViewModel
import com.imyyq.sample.data.Repository
import com.imyyq.sample.entity.handleResult
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class NetworkViewModel(app: Application, model: Repository) : BaseViewModel<Repository>(app, model) {
    val resultCode = ObservableField<String>()

    override fun onResume() {
        // 使用 vm 的协程，可以在界面销毁时自动取消该协程
        viewModelScope.launch {
            showLoadingDialog()
            val entity = mModel.login("userName", "pwd")
            handleResult(entity,
                onSuccess = {
                    Log.i("NetworkViewModel", "commonLog - onResume: success")
                },
                onResult = {
                    Log.i("NetworkViewModel", "commonLog - onResult: ${it.size}")
                },
                onFailed = { code, msg ->
                    Log.i("NetworkViewModel", "commonLog - onFailed: $code, $msg")
                }
            )
            delay(2000)
            dismissDialog()
        }
    }
}