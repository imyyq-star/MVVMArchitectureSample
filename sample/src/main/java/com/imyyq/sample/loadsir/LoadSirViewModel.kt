package com.imyyq.sample.loadsir

import android.app.Application
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewModelScope
import com.imyyq.mvvm.base.BaseModel
import com.imyyq.mvvm.base.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoadSirViewModel(app: Application) : BaseViewModel<BaseModel>(app) {
    override fun onResume(owner: LifecycleOwner) {
        viewModelScope.launch {
            delay(2000)
            showLoadSirSuccess()
        }
    }
}