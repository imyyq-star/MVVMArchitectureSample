package com.imyyq.sample

import android.view.LayoutInflater
import android.view.ViewGroup
import com.imyyq.mvvm.base.NoViewModelBaseActivity
import com.imyyq.sample.databinding.ActivityNoViewModelBinding

class TestNoViewModelActivity : NoViewModelBaseActivity<ActivityNoViewModelBinding>() {
    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        ActivityNoViewModelBinding.inflate(inflater)
}