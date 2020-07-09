package com.imyyq.sample.vp

import com.imyyq.mvvm.base.DataBindingBaseActivity
import com.imyyq.sample.BR
import com.imyyq.sample.R
import com.imyyq.sample.databinding.ActivityVpBinding

class ViewPagerActivity : DataBindingBaseActivity<ActivityVpBinding, ViewPagerViewModel>(
    R.layout.activity_vp, BR.viewModel
) {
}