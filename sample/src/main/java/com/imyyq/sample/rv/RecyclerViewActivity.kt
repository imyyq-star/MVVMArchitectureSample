package com.imyyq.sample.rv

import com.imyyq.mvvm.base.BaseActivity
import com.imyyq.sample.BR
import com.imyyq.sample.R
import com.imyyq.sample.databinding.ActivityRvBinding

class RecyclerViewActivity : BaseActivity<ActivityRvBinding, RecyclerViewViewModel>(
    R.layout.activity_rv, BR.viewModel
) {
}