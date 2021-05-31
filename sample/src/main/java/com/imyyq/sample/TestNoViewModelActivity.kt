package com.imyyq.sample

import com.imyyq.mvvm.base.AppBarNoViewModelBaseActivity
import com.imyyq.sample.databinding.ActivityNoViewModelBinding
import com.imyyq.sample.databinding.LayoutCommonAppBarBinding

class TestNoViewModelActivity :
    AppBarNoViewModelBaseActivity<ActivityNoViewModelBinding, LayoutCommonAppBarBinding>() {
    override fun initData() {
        // 如果你的 xml 是 DataBinding 的，而且 text 属性还设置了值，那么可能会被 DataBinding 的覆盖掉
        mAppBarBinding.tvTitle.text = "沒有 VM 有标题栏的 Activity"
    }
}