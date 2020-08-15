package com.imyyq.sample.nav

import android.app.Application
import android.util.Log
import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.Navigation
import com.imyyq.mvvm.base.BaseModel
import com.imyyq.mvvm.base.BaseViewModel

class StartViewModel(app: Application) : BaseViewModel<BaseModel>(app) {
    val onClick = View.OnClickListener {
        val action = StartFragmentDirections.endAction("hello")
        Navigation.findNavController(it).navigate(action)
    }

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.i("StartViewModel", "onCreate: $this")
    }
}