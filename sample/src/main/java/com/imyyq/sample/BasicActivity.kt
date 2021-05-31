package com.imyyq.sample

import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.collection.arrayMapOf
import androidx.lifecycle.Observer
import com.imyyq.mvvm.base.AppBarDataBindingBaseActivity
import com.imyyq.mvvm.bus.LiveDataBus
import com.imyyq.mvvm.utils.LogUtil
import com.imyyq.sample.app.MyCommonAppBarProcessor
import com.imyyq.sample.databinding.ActivityBasicBinding
import com.imyyq.sample.databinding.LayoutCommonAppBarBinding

/**
 * 演示下部分功能的 DataBinding 使用。
 *
 */
class BasicActivity : AppBarDataBindingBaseActivity<ActivityBasicBinding, BasicViewModel, LayoutCommonAppBarBinding, MyCommonAppBarProcessor>(
    BR.viewModel, BR.appBarProcessor
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
        mViewModel.setResult(Activity.RESULT_CANCELED, arrayMapOf("heihei" to "map"))
        mViewModel.finish()
//        super.onBackPressed()
    }
}