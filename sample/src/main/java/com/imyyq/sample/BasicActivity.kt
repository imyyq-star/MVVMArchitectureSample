package com.imyyq.sample

import android.app.Activity
import android.util.Log
import androidx.lifecycle.Observer
import com.imyyq.mvvm.base.DataBindingBaseActivity
import com.imyyq.mvvm.bus.LiveDataBus
import com.imyyq.mvvm.utils.LogUtil
import com.imyyq.sample.databinding.ActivityBasicBinding

/**
 * 演示下部分功能的 DataBinding 使用。
 *
 */
class BasicActivity : DataBindingBaseActivity<ActivityBasicBinding, BasicViewModel>(
    R.layout.activity_basic, BR.viewModel
) {
    override fun initParam() {
        val bundle = getBundle()
        LogUtil.i("BasicActivity", "commonLog - initParam: $bundle")

        LiveDataBus.observe<List<Int>>(this, "", Observer {
            Log.i("BasicActivity", "commonLog - initParam: $it")
        })

        LiveDataBus.observe<List<Int>>(this, "", Observer {
            Log.i("BasicActivity", "commonLog - initParam: $it")
        })
    }

    override fun isSupportSwipe(): Boolean {
        return true
    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_OK)
        super.onBackPressed()
    }
}