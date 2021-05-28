package com.imyyq.sample.nav

import android.view.LayoutInflater
import android.view.ViewGroup
import com.imyyq.mvvm.base.AppBarNoViewModelBaseFragment
import com.imyyq.sample.databinding.ActivityNoViewModelBinding
import com.imyyq.sample.databinding.LayoutCommonAppBarBinding

class TestNoViewModelFragment : AppBarNoViewModelBaseFragment<ActivityNoViewModelBinding, LayoutCommonAppBarBinding>() {
    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        ActivityNoViewModelBinding.inflate(inflater)

    override fun initAppBarBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = LayoutCommonAppBarBinding.inflate(inflater, container, false)
}