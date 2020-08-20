package com.imyyq.sample

import android.app.Activity
import android.content.Intent
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

        // 监听事件总线
        LiveDataBus.observe<List<Int>>(this, "normal", Observer {
            Log.i("BasicActivity", "LiveDataBus - initParam: $it")
        })

        // 监听粘性事件
        LiveDataBus.observeSticky<List<String>>(this, "sticky", Observer {
            Log.i("BasicActivity", "LiveDataBus - initParam: sticky $it")
        })
    }

    // 支持侧滑返回
    override fun isSupportSwipe(): Boolean {
        return true
    }

    // startActivityForResult 返回结果
    override fun onBackPressed() {
        val intent = Intent()
        intent.putExtra("heihei", "basic")
//        mViewModel.setResult(Activity.RESULT_CANCELED, mutableMapOf("heihei" to "map"))
//        mViewModel.finish(Activity.RESULT_CANCELED, mutableMapOf("heihei" to "map"))
//        mViewModel.finish(Activity.RESULT_CANCELED, intent)
        mViewModel.setResult(Activity.RESULT_CANCELED, mutableMapOf("heihei" to "map"))
        mViewModel.finish()
//        super.onBackPressed()
    }
}