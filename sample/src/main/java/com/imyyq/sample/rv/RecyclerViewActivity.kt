package com.imyyq.sample.rv

import com.imyyq.mvvm.base.AppBarDataBindingBaseActivity
import com.imyyq.sample.BR
import com.imyyq.sample.R
import com.imyyq.sample.app.MyCommonAppBarProcessor2
import com.imyyq.sample.databinding.ActivityRvBinding
import com.imyyq.sample.databinding.LayoutCommonAppBar2Binding

/**
 * 标题栏除了可以全局配置，还可以局部自定义换成其他的，比如这里就换成了 layout_common_app_bar2.xml
 */
class RecyclerViewActivity : AppBarDataBindingBaseActivity<ActivityRvBinding, RecyclerViewViewModel, LayoutCommonAppBar2Binding, MyCommonAppBarProcessor2>(
    R.layout.activity_rv, BR.viewModel, BR.appBarProcessor, R.layout.layout_common_app_bar2
) {
}