package com.imyyq.sample

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.viewModelScope
import com.imyyq.mvvm.base.BaseViewModel
import com.imyyq.sample.data.Repository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class NetworkViewModel(app: Application, model: Repository) : BaseViewModel<Repository>(app, model) {
    val resultCode = ObservableField<String>()

    override fun onResume() {
        // 使用 vm 的协程，可以在界面销毁时自动取消该协程
        viewModelScope.launch {
            showLoadingDialog()
            val entity = mModel.login("userName", "pwd")
            delay(2000)
            resultCode.set(entity?.errorCode?.toString())
            dismissDialog()
        }
    }
}