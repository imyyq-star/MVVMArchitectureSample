package com.imyyq.sample.vp

import com.imyyq.mvvm.base.DataBindingFragment
import com.imyyq.sample.BR
import com.imyyq.sample.R
import com.imyyq.sample.databinding.FragmentVpBinding

class ViewPagerFragment : DataBindingFragment<FragmentVpBinding, VpFragmentViewModel>(
    R.layout.fragment_vp, BR.viewModel
) {
}