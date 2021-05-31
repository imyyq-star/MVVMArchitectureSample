package com.imyyq.sample.nav

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import com.imyyq.mvvm.base.AppBarDataBindingBaseFragment
import com.imyyq.mvvm.bus.LiveDataBus
import com.imyyq.mvvm.utils.LogUtil
import com.imyyq.sample.BR
import com.imyyq.sample.app.MyCommonAppBarProcessor
import com.imyyq.sample.databinding.FragmentStartBinding
import com.imyyq.sample.databinding.LayoutCommonAppBarBinding


class StartFragment : AppBarDataBindingBaseFragment<FragmentStartBinding, StartViewModel, LayoutCommonAppBarBinding, MyCommonAppBarProcessor>(
    BR.viewModel, BR.appBarProcessor, sharedViewModel = true
) {
    override fun onResume() {
        super.onResume()
        LogUtil.i("StartFragment", "commonLog - onResume: $mBinding, $mViewModel")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        LogUtil.i("StartFragment", "commonLog - onViewCreated: $mBinding, $mViewModel")
        LiveDataBus.observeSticky<List<String>>(this, "sticky", Observer {
            Log.i("StartFragment", "LiveDataBus - onViewCreated: sticky $it")
        })
    }
}