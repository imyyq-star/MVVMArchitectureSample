package com.imyyq.sample

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.viewModelScope
import com.imyyq.mvvm.base.BaseViewModel
import com.imyyq.sample.data.Repository
import kotlinx.coroutines.launch

class NetworkViewModel(app: Application, private val repository: Repository) :
    BaseViewModel<Repository>(app, repository) {
    val resultCode = ObservableField<String>()

    override fun onResume() {
        // 使用 vm 的协程，可以在界面销毁时自动取消该协程
        viewModelScope.launch {
            val entity = repository.login("userName", "pwd")
            resultCode.set(entity?.errorCode?.toString())
        }
    }
}