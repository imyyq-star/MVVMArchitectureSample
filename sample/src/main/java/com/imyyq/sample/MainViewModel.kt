package com.imyyq.sample

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.imyyq.mvvm.base.BaseModel
import com.imyyq.mvvm.base.BaseViewModel
import com.imyyq.mvvm.bus.LiveDataBus
import com.imyyq.mvvm.utils.LogUtil
import com.imyyq.sample.app.MyApp
import com.imyyq.sample.db.DBActivity
import com.imyyq.sample.loadsir.LoadSirActivity
import com.imyyq.sample.nav.NavActivity
import com.imyyq.sample.rv.RecyclerViewActivity
import com.imyyq.sample.vp.ViewPager2Activity
import com.imyyq.sample.vp.ViewPagerActivity

/**
 * ViewModel 层需要继承 BaseViewModel。最终继承自 AndroidViewModel，这样可拥有 Application 的实例。
 *
 * 如果没有数据仓库，可以使用 BaseModel 作为 Model 层。
 */
class MainViewModel(app: Application) : BaseViewModel<BaseModel>(app) {
    val liveData = MutableLiveData<String>()

    // 可监听其他 LiveData 的变化
    val liveData2: LiveData<Int> = Transformations.map(liveData) {
        // liveData 变量的值做操作
        return@map 1 // 最后返回结果
    }

    val onBasic = View.OnClickListener {
        // 可以携带参数
        val bundle = Bundle()
        bundle.putString("test", "hei")
        startActivityForResult(BasicActivity::class.java, bundle)
        // 可以直接 map 传递各种 key、value，支持 Intent 和 Bundle 所有的数据类型
//        startActivity(BasicActivity::class.java, mutableMapOf("test2" to 1, "test" to "hahahah"
//        , "test3" to arrayOf("ssss", "bbbb")))
    }

    val onListView = View.OnClickListener {
        startActivity(ListViewActivity::class.java)
    }

    val onRv = View.OnClickListener {
        startActivity(RecyclerViewActivity::class.java)
    }

    val onVp = View.OnClickListener {
        startActivity(ViewPagerActivity::class.java)
    }

    val onVp2 = View.OnClickListener {
        startActivity(ViewPager2Activity::class.java)
    }

    val onNetwork = View.OnClickListener {
        startActivity(NetworkActivity::class.java)
    }

    val onDatabase = View.OnClickListener {
        startActivity(DBActivity::class.java)
    }

    val onLoadSir = View.OnClickListener {
        startActivity(LoadSirActivity::class.java)
    }

    val onNav = View.OnClickListener {
        startActivity(NavActivity::class.java)
    }

    val onTest = View.OnClickListener {
        LiveDataBus.send("normal", listOf("我是1", "我是2"))
        LiveDataBus.send("forever", listOf("我是3", "我是4"))
        LiveDataBus.sendSticky("sticky", listOf("我是5", "我是6"))
    }

    /**
     * 默认返回 true，则框架可以帮你缓存自动创建的 Model 实例，即 Model 会是单例的
     */
    override fun isCacheRepo(): Boolean {
        return super.isCacheRepo()
    }

    // =========================================================================================================

    /**
     * vm 可以感知 v 的生命周期
     */
    override fun onResume(owner: LifecycleOwner) {
        // 注意！！！！！ vm 层绝对不可以引用 v 层的实例，需要 context 要么通过 application，要么通过 AppActivityManager
        val app = getApplication<MyApp>()
        LogUtil.i("MainViewModel", "commonLog - onResume: $app")
        liveData.value = "hello"

        // vm 也有一系列的 getXxxFromXxx 方法
        getStringFromIntent("key")
        getStringFromBundle("key")

        // 使用 rx 进行耗时操作，可使用 addSubscribe 包裹订阅返回的 Disposable，这样在界面销毁时可同步取消耗时任务
//        addSubscribe()
        // retrofit 使用 Callback 进行耗时操作，可使用 addCall 包裹接口返回的 Call，这样在界面销毁时可同步取消耗时任务
//        addCall()

        // 取消当前 vm 发起的协程、rx、retrofit Callback 三种耗时任务
//        cancelConsumingTask()

        // 使用协程发起网络请求
//        launch()
        // 发起协程
//        launchUI {  }
        // 发起协程 Flow
//        launchFlow {  }
    }

    // 。。。。 还有其他的生命周期可复写

    /**
     * 这个是对应的界面调用 onDestroy 时的回调
     */
    override fun onDestroy(owner: LifecycleOwner) {
    }

    /**
     * 这个是当前 vm 销毁时的回调。
     */
    override fun onCleared() {
        super.onCleared()
    }

    // =========================================================================================================
    // 当你使用 Activity 或者使用 BaseViewModel 中的 startActivityForResult 方法，时，以下三个方法可用。
    // 在 BaseViewModel 中也有相应的方法

    override fun onActivityResult(resultCode: Int, intent: Intent) {
        LogUtil.i("MainViewModel", "onActivityResult: $resultCode, ${intent.getStringExtra("heihei")}")
    }

    override fun onActivityResultOk(intent: Intent) {
        LogUtil.i("MainViewModel", "onActivityResultOk: ${intent.getStringExtra("heihei")}")
    }

    override fun onActivityResultCanceled(intent: Intent) {
        LogUtil.i("MainViewModel", "onActivityResultCanceled: ${intent.getStringExtra("heihei")}")
    }
}