package com.imyyq.sample.nav

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.imyyq.mvvm.base.ViewBindingBaseActivity
import com.imyyq.mvvm.utils.LogUtil
import com.imyyq.sample.databinding.ActivityNavBinding

class NavActivity : ViewBindingBaseActivity<ActivityNavBinding, NavViewModel>() {
    override fun initData() {
        supportFragmentManager.registerFragmentLifecycleCallbacks(object :
            FragmentManager.FragmentLifecycleCallbacks() {

            override fun onFragmentCreated(
                fm: FragmentManager,
                f: Fragment,
                savedInstanceState: Bundle?
            ) {
                LogUtil.i("NavActivity", "commonLog - onFragmentCreated: $f")
            }

            override fun onFragmentStarted(fm: FragmentManager, f: Fragment) {
                LogUtil.i("NavActivity", "commonLog - onFragmentStarted: $f")
            }

            override fun onFragmentResumed(fm: FragmentManager, f: Fragment) {
                LogUtil.i("NavActivity", "commonLog - onFragmentResumed: $f")
            }

            override fun onFragmentPaused(fm: FragmentManager, f: Fragment) {
                LogUtil.i("NavActivity", "commonLog - onFragmentPaused: $f")
            }

            override fun onFragmentStopped(fm: FragmentManager, f: Fragment) {
                LogUtil.i("NavActivity", "commonLog - onFragmentStopped: $f")
            }

            override fun onFragmentDestroyed(fm: FragmentManager, f: Fragment) {
                LogUtil.i("NavActivity", "commonLog - onFragmentDestroyed: $f")
            }

            override fun onFragmentActivityCreated(
                fm: FragmentManager,
                f: Fragment,
                savedInstanceState: Bundle?
            ) {
                LogUtil.i("NavActivity", "commonLog - onFragmentActivityCreated: $f")
            }

            override fun onFragmentViewCreated(
                fm: FragmentManager,
                f: Fragment,
                v: View,
                savedInstanceState: Bundle?
            ) {
                LogUtil.i("NavActivity", "commonLog - onFragmentViewCreated: $f")
            }

            override fun onFragmentViewDestroyed(fm: FragmentManager, f: Fragment) {
                LogUtil.i("NavActivity", "commonLog - onFragmentViewDestroyed: $f")
            }

        }, true)
    }
}