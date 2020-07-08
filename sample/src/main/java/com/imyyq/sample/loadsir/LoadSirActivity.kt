package com.imyyq.sample.loadsir

import com.imyyq.mvvm.utils.LogUtil
import com.imyyq.mvvm.base.BaseActivity
import com.imyyq.sample.BR
import com.imyyq.sample.R
import com.imyyq.sample.databinding.ActivityLoadsirBinding

class LoadSirActivity : BaseActivity<ActivityLoadsirBinding, LoadSirViewModel>(
    R.layout.activity_loadsir, BR.viewModel
) {
    override fun getLoadSirTarget(): Any? {
        return mBinding.layoutRoot
    }

    override fun onLoadSirReload() {
        LogUtil.i("LoadSirActivity", "commonLog - onLoadSirReload: ")
    }
}