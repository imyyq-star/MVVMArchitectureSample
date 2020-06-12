package com.imyyq.sample

import android.app.Application
import androidx.databinding.ObservableField
import com.imyyq.mvvm.base.BaseModel
import com.imyyq.mvvm.base.BaseViewModel
import com.imyyq.mvvm.utils.SingleLiveEvent

class BasicViewModel(app: Application) : BaseViewModel<BaseModel>(app) {
    // 使用 ObservableXXX
    val mText = ObservableField<String>()
    // 还可以使用 LiveData
    val mImageUrl = SingleLiveEvent<String>()

    init {
        mText.set("我是一个文本，引用了 vm 的可观察字段，当字段更新，我将自动更新")
        /*
         这是一个图片，使用 glide 数据绑定 [com.imyyq.mvvm.binding.viewadapter.image.ViewAdapter] 来加载图片
         其他的使用，详见 com.imyyq.mvvm.binding 包。
         当然也可以自定义，这块的功能完全是属于 DataBinding 的
         */
        mImageUrl.value = "https://dss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1752460159,226752426&fm=26&gp=0.jpg"
    }
}