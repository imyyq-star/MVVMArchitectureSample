package com.imyyq.sample

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.View
import com.imyyq.mvvm.base.BaseModel
import com.imyyq.mvvm.base.BaseViewModel
import com.imyyq.mvvm.binding.command.BindingAction
import com.imyyq.mvvm.binding.command.BindingCommand
import com.imyyq.mvvm.binding.command.BindingConsumer
import com.imyyq.sample.app.MyApp

/**
 * ViewModel 层需要继承 BaseViewModel。最终继承自 AndroidViewModel，这样可拥有 Application 的实例。
 *
 * 如果没有数据仓库，可以使用 BaseModel 作为 Model 层。
 */
class MainViewModel(app: Application) : BaseViewModel<BaseModel>(app) {

    val onNetwork = BindingCommand(object : BindingConsumer<View> {
        override fun call(t: View) {
            startActivity(NetworkActivity::class.java)
        }
    })

    val onBasic = BindingCommand(object : BindingConsumer<View> {
        override fun call(t: View) {
            showDialog()
            // 可以携带参数
            startActivity(BasicActivity::class.java, Bundle.EMPTY)
        }
    })

    val onListView = BindingCommand<View>(object : BindingAction {
        override fun call() {
            startActivity(ListViewActivity::class.java)
        }
    })

    /**
     * vm 可以感知 v 的生命周期
     */
    override fun onResume() {
        // 注意！！！！！ vm 层绝对不可以引用 v 层的实例，需要 context 要么通过 application，要么通过 AppActivityManager
        val app = getApplication<MyApp>()
        Log.i("MainViewModel", "commonLog - onResume: $app")
    }

    /**
     * 这个是对应的界面调用 onDestroy 时的回调
     */
    override fun onDestroy() {
    }

    /**
     * 这个是当前 vm 销毁时的回调。
     * 和 onDestroy 的区别是，如果界面是 Fragment，可能在 ViewPager 中时会多次的 destroy，但只有在完全销毁时才会 clear
     */
    override fun onCleared() {
        super.onCleared()
    }
}