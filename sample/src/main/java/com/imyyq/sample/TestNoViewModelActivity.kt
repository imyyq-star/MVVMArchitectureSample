package com.imyyq.sample

import android.view.LayoutInflater
import android.view.ViewGroup
import com.imyyq.mvvm.base.AppBarNoViewModelBaseActivity
import com.imyyq.sample.databinding.ActivityNoViewModelBinding
import com.imyyq.sample.databinding.LayoutCommonAppBarBinding

class TestNoViewModelActivity :
    AppBarNoViewModelBaseActivity<ActivityNoViewModelBinding, LayoutCommonAppBarBinding>() {
    override fun initData() {
        // 如果你的 xml 是 DataBinding 的，而且 text 属性还设置了值，那么可能会被 DataBinding 的覆盖掉
        mAppBarBinding.tvTitle.text = "沒有 VM 有标题栏的 Activity"
    }

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        ActivityNoViewModelBinding.inflate(inflater)

    override fun initAppBarBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = LayoutCommonAppBarBinding.inflate(inflater, container, false)
}