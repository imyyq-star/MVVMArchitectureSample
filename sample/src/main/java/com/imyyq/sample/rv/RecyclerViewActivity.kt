package com.imyyq.sample.rv

import com.imyyq.mvvm.base.DataBindingBaseActivity
import com.imyyq.sample.BR
import com.imyyq.sample.R
import com.imyyq.sample.databinding.ActivityRvBinding

class RecyclerViewActivity : DataBindingBaseActivity<ActivityRvBinding, RecyclerViewViewModel>(
    R.layout.activity_rv, BR.viewModel
) {
}