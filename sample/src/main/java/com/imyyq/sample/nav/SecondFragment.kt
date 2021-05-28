package com.imyyq.sample.nav

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.imyyq.mvvm.base.AppBarViewBindingBaseFragment
import com.imyyq.mvvm.utils.LogUtil
import com.imyyq.sample.R
import com.imyyq.sample.databinding.FragmentSecondBinding
import com.imyyq.sample.databinding.LayoutCommonAppBarBinding

class SecondFragment : AppBarViewBindingBaseFragment<FragmentSecondBinding, StartViewModel, LayoutCommonAppBarBinding>() {
    val args: SecondFragmentArgs by navArgs()

    override fun initData() {
        LogUtil.i("SecondFragment", "commonLog - initData: $mViewModel, ${args.userName}")
    }

    override fun initViewObservable() {
        mBinding.btn.setOnClickListener { Navigation.findNavController(it).navigate(R.id.test_no_view_model) }
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSecondBinding = FragmentSecondBinding.inflate(inflater, container, false)

    override fun initAppBarBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = LayoutCommonAppBarBinding.inflate(inflater, container, false)
}