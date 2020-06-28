package com.imyyq.sample

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelStoreOwner
import com.imyyq.mvvm.base.BaseActivity
import com.imyyq.mvvm.binding.viewadapter.view.clickWithTrigger
import com.imyyq.mvvm.utils.CaptureAndCropManager
import com.imyyq.mvvm.utils.SystemUIUtil
import com.imyyq.sample.databinding.ActivityMainBinding

/**
 * View 层需要继承相应的基类：BaseFragment/BaseActivity
 *
 * ActivityMainBinding 是 R.layout.activity_main 生成的 binding 类，DataBinding 相关的知识。
 * MainViewModel 是界面的主 vm，如果你的界面没有 vm，可以用 BaseViewModel。
 *
 * 构造需传入两个参数，一个是界面的 xml 界面，另一个是 vm 在 xml 中的变量，详见 xml 的配置。
 * 如果 xml 没有配置 vm 变量，可不传。
 */
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    R.layout.activity_main, BR.viewModel
) {
    // 除了主 vm，还可以有其他的 vm，来自 fragment-ktx 的 viewModels 扩展，可快速一行代码创建实例
    private val mTestViewModel by viewModels<TestViewModel>()

    // 是否保持界面常亮。
    override fun isKeepScreenOn(): Boolean {
        return super.isKeepScreenOn()
    }

    // 是否需要对话框
    override fun isNeedLoadingDialog(): Boolean {
        return super.isNeedLoadingDialog()
    }

    // vm 是否需要启动和结束界面
    override fun isViewModelNeedStartAndFinish(): Boolean {
        return super.isViewModelNeedStartAndFinish()
    }

    override fun onResume() {
        super.onResume()
        // 操控 systemUI
        SystemUIUtil.fullscreenImmersive(window)
    }

    /**
     * 打开这个界面时传入的参数可以在这里处理。
     *
     * 此时 mViewModel 和 mBinding 还没有实例化。
     */
    override fun initParam() {
        mTestViewModel.test()
    }

    /**
     * 这个方法是用来绑定 vm 中的响应式变量到界面中的，比如 LiveData。
     *
     * 此时 mViewModel 和 mBinding 已实例化。
     */
    override fun initViewObservable() {
        // mViewModel 是界面关联的主 VM 的实例，有上述的泛型参数决定，这里是 MainViewModel。
        // mBinding 是 layout 文件的绑定类，包含了声明了 id 的所有 view 的引用。
        Log.i("MainActivity", "initViewObservable: $mViewModel, $mBinding")
    }

    /**
     * 这个方法被调用时，此时界面已经初始化完毕了，可以进行获取数据的操作了，比如请求网络。
     */
    override fun initData() {
        super.initData()
        //指定某控件点击间隔时间：1000毫秒
        mBinding.btn.clickWithTrigger(1000, View.OnClickListener {
            Log.i("MainActivity", "initData: ")
            CaptureAndCropManager.capturePhotoFromCamera(this, 100)
        })
    }

    override fun isViewModelNeedStartForResult(): Boolean {
        return true
    }

    override fun onActivityResult(resultCode: Int, intent: Intent) {
        Log.i("MainActivity", "onActivityResult: $resultCode, $intent")
    }

    /**
     * 如果你的 vm 是通过 自定义 factory 创建的，可复写此方法。
     * 否则将由框架帮你实例化 vm。
     */
    override fun initViewModel(viewModelStoreOwner: ViewModelStoreOwner): MainViewModel {
        return super.initViewModel(viewModelStoreOwner)
    }
}
