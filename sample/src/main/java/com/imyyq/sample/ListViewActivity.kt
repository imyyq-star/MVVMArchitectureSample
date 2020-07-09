package com.imyyq.sample

import com.imyyq.mvvm.base.DataBindingBaseActivity
import com.imyyq.sample.databinding.ActivityListViewBinding

class ListViewActivity : DataBindingBaseActivity<ActivityListViewBinding, ListViewViewModel>(
    R.layout.activity_list_view, BR.viewModel
) {
}