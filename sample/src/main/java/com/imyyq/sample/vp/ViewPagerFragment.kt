package com.imyyq.sample.vp

import com.imyyq.mvvm.base.DataBindingBaseFragment
import com.imyyq.sample.BR
import com.imyyq.sample.R
import com.imyyq.sample.databinding.FragmentVpBinding

class ViewPagerFragment : DataBindingBaseFragment<FragmentVpBinding, VpFragmentViewModel>(
    R.layout.fragment_vp, BR.viewModel
) {
}