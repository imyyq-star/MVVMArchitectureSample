package com.imyyq.sample

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.imyyq.mvvm.base.BaseModel
import com.imyyq.mvvm.base.BaseViewModel
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

    val onNetwork = View.OnClickListener {
        startActivity(NetworkActivity::class.java)
    }

    val onLoadSir = View.OnClickListener {
        startActivity(LoadSirActivity::class.java)
    }

    val onBasic = View.OnClickListener {
        // 可以携带参数
        startActivityForResult(BasicActivity::class.java, Bundle.EMPTY)
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

    override fun onActivityResult(resultCode: Int, intent: Intent) {
        Log.i("MainViewModel", "onActivityResult: $resultCode, $intent")
    }

    /**
     * 这个是当前 vm 销毁时的回调。
     * 和 onDestroy 的区别是，如果界面是 Fragment，可能在 ViewPager 中时会多次的 destroy，但只有在完全销毁时才会 clear
     */
    override fun onCleared() {
        super.onCleared()
    }
}