package com.imyyq.sample.nav

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import com.imyyq.mvvm.base.DataBindingBaseFragment
import com.imyyq.mvvm.bus.LiveDataBus
import com.imyyq.mvvm.utils.LogUtil
import com.imyyq.sample.BR
import com.imyyq.sample.R
import com.imyyq.sample.databinding.FragmentStartBinding


class StartFragment : DataBindingBaseFragment<FragmentStartBinding, StartViewModel>(
    R.layout.fragment_start, BR.viewModel
) {
    override fun onResume() {
        super.onResume()
        LogUtil.i("StartFragment", "commonLog - onResume: $mBinding, $mViewModel")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        LogUtil.i("StartFragment", "commonLog - onViewCreated: $mBinding, $mViewModel")
        LiveDataBus.observeSticky<List<Int>>(this, "sticky", Observer {
            Log.i("StartFragment", "commonLog - onViewCreated: sticky $it")
        })
    }
}