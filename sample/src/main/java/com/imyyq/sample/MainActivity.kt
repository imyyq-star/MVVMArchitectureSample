package com.imyyq.sample

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelStoreOwner
import com.imyyq.mvvm.app.AppActivityManager
import com.imyyq.mvvm.base.AppBarDataBindingBaseActivity
import com.imyyq.mvvm.binding.viewadapter.view.clickWithTrigger
import com.imyyq.mvvm.bus.LiveDataBus
import com.imyyq.mvvm.utils.CaptureAndCropManager
import com.imyyq.mvvm.utils.LogUtil
import com.imyyq.mvvm.utils.SystemUIUtil
import com.imyyq.sample.app.MyCommonAppBarProcessor
import com.imyyq.sample.databinding.ActivityMainBinding
import com.imyyq.sample.databinding.LayoutCommonAppBarBinding
import com.kingja.loadsir.callback.Callback

class MainActivity : AppBarDataBindingBaseActivity<ActivityMainBinding, MainViewModel, LayoutCommonAppBarBinding, MyCommonAppBarProcessor>(
    BR.viewModel, BR.appBarProcessor,
) {
    // 除了主 vm，还可以有其他的 vm，来自 fragment-ktx 的 viewModels 扩展，可快速一行代码创建实例
    private val mTestViewModel by viewModels<TestViewModel>()

    /**
     * 初始化的第一个方法。
     *
     * 打开这个界面时传入的参数可以在这里处理。
     *
     * 此时 mViewModel 和 mBinding 已实例化。
     */
    override fun initParam() {
        getStringFromBundle("key")
        getStringFromIntent("key")
        // 还有很多的 getXxxxFromXxxx 方法可以用，在 ViewModel 中也可以有

        // 给 xml 中的变量赋值
        mBinding.testViewModel = mTestViewModel
        mTestViewModel.test()

        // 事件总线，监听生命周期无关的事件
        LiveDataBus.observe(this,"forever", Observer {
            Log.i("MainActivity", "LiveDataBus - initParam: observeForever $it")
        }, true)
        // 监听生命周期有关的事件
        LiveDataBus.observe<List<String>>(this, "normal", Observer {
            Log.i("MainActivity", "LiveDataBus - initParam: observe $it")
        })
    }

    /**
     * 初始化的第二个方法
     *
     * 这个方法是用来绑定 vm 中的响应式变量到界面中的，通常是 LiveData，事件监听等。
     *
     * 此时 mViewModel 和 mBinding 已实例化。
     */
    override fun initViewObservable() {
        // mBinding 是 layout 文件的绑定类，包含了声明了 id 的所有 view 的引用。这里就是对应 R.layout.activity_main
        // mViewModel 是界面关联的主 VM 的实例，由继承 DataBindingBaseActivity 时的泛型参数决定，这里是 MainViewModel。
        LogUtil.i("MainActivity", "initViewObservable: $mViewModel, $mBinding")

        // 父类中提供了简便的 observe 方法
        observe(mViewModel.liveData, this::onChanged)
        observe(mViewModel.liveData) {

        }
        // 当然也可以这样用
        mViewModel.liveData.observe(this, Observer {

        })
    }

    /**
     * 初始化的最后一个方法
     *
     * 这个方法被调用时，此时界面已经初始化完毕了，可以进行获取数据的操作了，比如请求网络等。
     */
    override fun initData() {
        // 可在 xml 中设定点击间隔时间，也可通过代码指定某控件点击间隔时间，毫秒为单位
        mBinding.btn.clickWithTrigger(1000, View.OnClickListener {
            LogUtil.i("MainActivity", "initData: ")
            CaptureAndCropManager.capturePhotoFromCamera(this, 100)
        })

        // GlobalConfig.gIsNeedActivityManager 为 true，则可以使用 AppActivityManager 类获取当前应用的 activity 堆栈
        AppActivityManager.currentActivity()

        // 父类提供了便捷的方法可调用
//        startActivity(clz, map, bundle)
//        startActivityForResult(clz, map, bundle)
    }

    // 是否开启界面侧滑退出，需对应的主题背景透明
    override fun isSupportSwipe(): Boolean {
        return super.isSupportSwipe()
    }

    override fun onResume() {
        super.onResume()
        // 操控 systemUI
        SystemUIUtil.fullscreenImmersive(window)
    }

    private fun onChanged(s: String) {

    }

    /**
     * 如果你的 vm 是通过 自定义 factory 创建的，可复写此方法。
     * 否则将由框架帮你实例化 vm。
     */
    override fun initViewModel(viewModelStoreOwner: ViewModelStoreOwner): MainViewModel {
        return super.initViewModel(viewModelStoreOwner)
    }

    // =========================================================================================================

    // vm 是否需要启动和结束界面
    override fun isViewModelNeedStartAndFinish(): Boolean {
        return super.isViewModelNeedStartAndFinish()
    }

    override fun isViewModelNeedStartForResult(): Boolean {
        return true
    }

    // =========================================================================================================
    // 以下是加载中对话框的相关方法

    override fun isNeedLoadingDialog(): Boolean {
        return super.isNeedLoadingDialog()
    }

    override fun onCancelLoadingDialog() {
        super.onCancelLoadingDialog()
    }

    override fun loadingDialogLayout(): Int {
        return super.loadingDialogLayout()
    }

    override fun loadingDialogLayoutMsgId(): Int {
        return super.loadingDialogLayoutMsgId()
    }

    override fun isLoadingDialogCancelable(): Boolean {
        return super.isLoadingDialogCancelable()
    }

    override fun isLoadingDialogCanceledOnTouchOutside(): Boolean {
        return super.isLoadingDialogCanceledOnTouchOutside()
    }

    override fun isCancelConsumingTaskWhenLoadingDialogCanceled(): Boolean {
        return super.isCancelConsumingTaskWhenLoadingDialogCanceled()
    }

    // =========================================================================================================
    // 以下是开启了 LoadSir 第三方框架时，在 BaseViewModel 中调用 showLoadSir 方法时的相关回调

    override fun onLoadSirShowed(it: Class<out Callback>) {
        super.onLoadSirShowed(it)
    }

    override fun onLoadSirSuccess() {
        super.onLoadSirSuccess()
    }

    override fun onLoadSirReload() {
        super.onLoadSirReload()
    }

    // 开启 LoadSir 需要复写以下方法，告知父类你的目标视图
    override fun getLoadSirTarget(): Any? {
        return super.getLoadSirTarget()
    }

    // =========================================================================================================
    // 当你使用 Activity 或者使用 BaseViewModel 中的 startActivityForResult 方法，时，以下三个方法可用。
    // 在 BaseViewModel 中也有相应的方法

    override fun onActivityResultOk(intent: Intent) {
        super.onActivityResultOk(intent)
    }

    override fun onActivityResultCanceled(intent: Intent) {
        super.onActivityResultCanceled(intent)
    }

    override fun onActivityResult(resultCode: Int, intent: Intent) {
        LogUtil.i("MainActivity", "onActivityResult: $resultCode, $intent")
    }
}
