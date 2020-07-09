package com.imyyq.sample

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.imyyq.mvvm.base.DataBindingBaseActivity
import com.imyyq.sample.app.AppViewModelFactory
import com.imyyq.sample.databinding.ActivityNetworkBinding

class NetworkActivity : DataBindingBaseActivity<ActivityNetworkBinding, NetworkViewModel>(
    R.layout.activity_network, BR.viewModel
) {
    /**
     * 如果你的 vm 是带有仓库的，那么需要自己实现 factory，注入仓库实例。
     * 当然也可以简单点直接在 vm 使用该仓库，不过为了解耦，还是单独抽出来比较合理
     */
    override fun initViewModel(viewModelStoreOwner: ViewModelStoreOwner): NetworkViewModel {
        return ViewModelProvider(
            viewModelStoreOwner,
            AppViewModelFactory
        ).get(NetworkViewModel::class.java)
    }

    override fun isLoadingDialogCancelable(): Boolean {
        return true
    }

    override fun isCancelConsumingTaskWhenLoadingDialogCanceled(): Boolean {
        return true
    }
}