package com.imyyq.sample.rv

import com.imyyq.mvvm.base.MultiItemViewModel

class RvItemViewModel(
    viewModel: RecyclerViewViewModel, val item: String
) : MultiItemViewModel<RecyclerViewViewModel>(viewModel) {

}