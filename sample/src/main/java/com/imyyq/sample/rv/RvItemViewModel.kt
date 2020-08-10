package com.imyyq.sample.rv

import com.imyyq.mvvm.base.MultiItemViewModel

/**
 * 可使用框架提供的 [MultiItemViewModel] 和 [ItemViewModel]，作为每一个 item 的 vm 父类
 */
class RvItemViewModel(
    viewModel: RecyclerViewViewModel, val item: String
) : MultiItemViewModel<RecyclerViewViewModel>(viewModel) {

}