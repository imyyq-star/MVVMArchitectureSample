package com.imyyq.sample.nav

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.imyyq.mvvm.base.BaseActivity
import com.imyyq.sample.BR
import com.imyyq.sample.R
import com.imyyq.sample.databinding.ActivityNavBinding

class NavActivity : BaseActivity<ActivityNavBinding, NavViewModel>(
    R.layout.activity_nav, BR.viewModel
) {
    override fun initData() {
        super.initData()
        supportFragmentManager.registerFragmentLifecycleCallbacks(object :
            FragmentManager.FragmentLifecycleCallbacks() {

            override fun onFragmentCreated(
                fm: FragmentManager,
                f: Fragment,
                savedInstanceState: Bundle?
            ) {
                Log.i("NavActivity", "commonLog - onFragmentCreated: $f")
            }

            override fun onFragmentStarted(fm: FragmentManager, f: Fragment) {
                Log.i("NavActivity", "commonLog - onFragmentStarted: $f")
            }

            override fun onFragmentResumed(fm: FragmentManager, f: Fragment) {
                Log.i("NavActivity", "commonLog - onFragmentResumed: $f")
            }

            override fun onFragmentPaused(fm: FragmentManager, f: Fragment) {
                Log.i("NavActivity", "commonLog - onFragmentPaused: $f")
            }

            override fun onFragmentStopped(fm: FragmentManager, f: Fragment) {
                Log.i("NavActivity", "commonLog - onFragmentStopped: $f")
            }

            override fun onFragmentDestroyed(fm: FragmentManager, f: Fragment) {
                Log.i("NavActivity", "commonLog - onFragmentDestroyed: $f")
            }

            override fun onFragmentActivityCreated(
                fm: FragmentManager,
                f: Fragment,
                savedInstanceState: Bundle?
            ) {
                Log.i("NavActivity", "commonLog - onFragmentActivityCreated: $f")
            }

            override fun onFragmentViewCreated(
                fm: FragmentManager,
                f: Fragment,
                v: View,
                savedInstanceState: Bundle?
            ) {
                Log.i("NavActivity", "commonLog - onFragmentViewCreated: $f")
            }

            override fun onFragmentViewDestroyed(fm: FragmentManager, f: Fragment) {
                Log.i("NavActivity", "commonLog - onFragmentViewDestroyed: $f")
            }

        }, true)
    }
}