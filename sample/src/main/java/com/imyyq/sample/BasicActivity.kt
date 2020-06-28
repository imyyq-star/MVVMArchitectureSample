package com.imyyq.sample

import android.app.Activity
import android.util.Log
import com.imyyq.mvvm.base.BaseActivity
import com.imyyq.sample.databinding.ActivityBasicBinding

/**
 * 演示下部分功能的 DataBinding 使用。
 *
 */
class BasicActivity : BaseActivity<ActivityBasicBinding, BasicViewModel>(
    R.layout.activity_basic, BR.viewModel
) {
    override fun initParam() {
        val bundle = getBundle(this)
        Log.i("BasicActivity", "commonLog - initParam: $bundle")
    }

    override fun isSupportSwipe(): Boolean {
        return true
    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_OK)
        super.onBackPressed()
    }
}