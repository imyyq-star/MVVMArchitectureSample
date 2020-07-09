package com.imyyq.sample.nav

import android.os.Bundle
import android.view.View
import com.imyyq.mvvm.base.DataBindingFragment
import com.imyyq.mvvm.utils.LogUtil
import com.imyyq.sample.BR
import com.imyyq.sample.R
import com.imyyq.sample.databinding.FragmentStartBinding

class StartFragment : DataBindingFragment<FragmentStartBinding, StartViewModel>(
    R.layout.fragment_start, BR.viewModel
) {
    override fun onResume() {
        super.onResume()
        LogUtil.i("StartFragment", "commonLog - onResume: $mBinding, $mViewModel")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        LogUtil.i("StartFragment", "commonLog - onViewCreated: $mBinding, $mViewModel")
    }
}