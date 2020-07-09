package com.imyyq.sample.vp

import com.imyyq.mvvm.base.DataBindingBaseActivity
import com.imyyq.sample.R
import com.imyyq.sample.BR
import com.imyyq.sample.databinding.ActivityVp2Binding

class ViewPager2Activity : DataBindingBaseActivity<ActivityVp2Binding, ViewPagerViewModel>(
    R.layout.activity_vp2, BR.viewModel
) {
}