package com.imyyq.sample.vp

import com.imyyq.mvvm.base.BaseActivity
import com.imyyq.sample.R
import com.imyyq.sample.BR
import com.imyyq.sample.databinding.ActivityVpBinding

class ViewPagerActivity : BaseActivity<ActivityVpBinding, ViewPagerViewModel>(
    R.layout.activity_vp, BR.viewModel
) {
}