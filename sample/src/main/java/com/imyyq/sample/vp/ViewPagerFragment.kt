package com.imyyq.sample.vp

import com.imyyq.mvvm.base.BaseFragment
import com.imyyq.sample.R
import com.imyyq.sample.BR
import com.imyyq.sample.databinding.FragmentVpBinding

class ViewPagerFragment : BaseFragment<FragmentVpBinding, VpFragmentViewModel>(
    R.layout.fragment_vp, BR.viewModel
) {
}