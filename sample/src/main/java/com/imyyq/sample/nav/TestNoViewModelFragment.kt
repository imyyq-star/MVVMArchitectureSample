package com.imyyq.sample.nav

import android.view.LayoutInflater
import android.view.ViewGroup
import com.imyyq.mvvm.base.NoViewModelBaseFragment
import com.imyyq.sample.databinding.ActivityNoViewModelBinding

class TestNoViewModelFragment : NoViewModelBaseFragment<ActivityNoViewModelBinding>() {
    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        ActivityNoViewModelBinding.inflate(inflater)
}