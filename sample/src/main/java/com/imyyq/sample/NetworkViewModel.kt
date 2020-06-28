package com.imyyq.sample

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewModelScope
import com.haroldadmin.cnradapter.NetworkResponse
import com.imyyq.mvvm.base.BaseViewModel
import com.imyyq.sample.data.Repository
import com.imyyq.sample.entity.handleResult
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class NetworkViewModel(app: Application, model: Repository) : BaseViewModel<Repository>(app, model) {
    val resultCode = ObservableField<String>()

    override fun onResume(owner: LifecycleOwner) {
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

            val entity2 = mModel.login2("userName", "pwd")
            when (entity2) {
                is NetworkResponse.Success -> {
                    Log.i("NetworkViewModel", "commonLog - Success: ${entity2.body}")
                }
                is NetworkResponse.ServerError -> {
                    Log.i("NetworkViewModel", "commonLog - ServerError: ${entity2.body}")
                }
                is NetworkResponse.NetworkError -> {
                    Log.i("NetworkViewModel", "commonLog - NetworkError: ${entity2.error}")
                }
                is NetworkResponse.UnknownError -> {
                    Log.i("NetworkViewModel", "commonLog - NetworkError: ${entity2.error}")
                }
            }
            delay(2000)
            dismissDialog()
        }
    }
}