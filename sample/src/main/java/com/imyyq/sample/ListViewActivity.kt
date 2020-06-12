package com.imyyq.sample

import com.imyyq.mvvm.base.BaseActivity
import com.imyyq.sample.databinding.ActivityListViewBinding

class ListViewActivity : BaseActivity<ActivityListViewBinding, ListViewViewModel>(
    R.layout.activity_list_view, BR.viewModel
) {
}