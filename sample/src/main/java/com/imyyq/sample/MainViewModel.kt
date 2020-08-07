package com.imyyq.sample

import android.app.Application
import android.content.Intent
import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
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

    val onNetwork = View.OnClickListener {
        startActivity(NetworkActivity::class.java)
    }

    val onLoadSir = View.OnClickListener {
        startActivity(LoadSirActivity::class.java)
    }

    val onBasic = View.OnClickListener {
        // 可以携带参数
//        val bundle = Bundle()
//        bundle.putString("test", "hei")
//        startActivityForResult(BasicActivity::class.java, bundle)
        startActivity(BasicActivity::class.java, mutableMapOf("test2" to 1, "test" to "hahahah"
        , "test3" to arrayOf("ssss", "bbbb")))
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

    val onDatabase = View.OnClickListener {
        startActivity(DBActivity::class.java)
    }

    val onNav = View.OnClickListener {
        startActivity(NavActivity::class.java)
    }

    val onTest = View.OnClickListener {
        LiveDataBus.send("normal", listOf("我是1", "我是2"))
        LiveDataBus.send("forever", listOf("我是3", "我是4"))
        LiveDataBus.sendSticky("sticky", listOf("我是1", "我是2"))
    }

    /**
     * 默认返回 true，则框架可以帮你缓存自动创建的 Model 实例
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
        LogUtil.i("MainViewModel", "onActivityResult: $resultCode, $intent")
    }

    override fun onActivityResultOk(intent: Intent) {
        super.onActivityResultOk(intent)
    }

    override fun onActivityResultCanceled(intent: Intent) {
        super.onActivityResultCanceled(intent)
    }
}