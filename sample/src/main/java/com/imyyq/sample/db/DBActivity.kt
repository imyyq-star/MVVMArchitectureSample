package com.imyyq.sample.db

import com.imyyq.mvvm.base.DataBindingBaseActivity
import com.imyyq.sample.BR
import com.imyyq.sample.R
import com.imyyq.sample.databinding.ActivityDbBinding

class DBActivity : DataBindingBaseActivity<ActivityDbBinding, DBViewModel>(
    BR.viewModel, R.layout.activity_db,
) {
}