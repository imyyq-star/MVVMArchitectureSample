package com.imyyq.sample.rv

import com.imyyq.mvvm.base.MultiItemViewModel

class RvItemViewModel(
    viewModel: RecyclerViewViewModel,
    mItemType: Any? = null
) : MultiItemViewModel<RecyclerViewViewModel>(viewModel, mItemType) {

}