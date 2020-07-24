package com.imyyq.sample

import android.app.Application
import android.util.Log
import android.view.View
import android.widget.CompoundButton
import androidx.databinding.ObservableField
import androidx.lifecycle.LifecycleOwner
import com.imyyq.mvvm.base.BaseModel
import com.imyyq.mvvm.base.BaseViewModel
import com.imyyq.mvvm.binding.command.BindingConsumer
import com.imyyq.mvvm.utils.SingleLiveEvent
import java.util.*

class BasicViewModel(app: Application) : BaseViewModel<BaseModel>(app) {
    // 使用 ObservableXXX
    val mText = ObservableField<String>()
    // 还可以使用 LiveData
    val mImageUrl = SingleLiveEvent<String>()

    val onImageClick = View.OnClickListener {
        mImageUrl.value = null
    }

    val onCheckedChangeListener = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
        Log.i("BasicViewModel", "commonLog - : $isChecked")
    }

    val textChanged = BindingConsumer<String> {
        Log.i("BasicViewModel", "commonLog - : $it")
    }

    init {
        mText.set("我是一个文本，引用了 vm 的可观察字段，当字段更新，我将自动更新")
        /*
         这是一个图片，使用 glide 数据绑定 [com.imyyq.mvvm.binding.viewadapter.image.ViewAdapter] 来加载图片
         其他的使用，详见 com.imyyq.mvvm.binding 包。
         当然也可以自定义，这块的功能完全是属于 DataBinding 的
         */
        mImageUrl.value = "https://dss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1752460159,226752426&fm=26&gp=0.jpg"

        // 不能在构造中获取
        Log.i("BasicViewModel", "commonLog - init: ${getStringFromBundle("test")}")
    }

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.i("BasicViewModel", "commonLog - onCreate: ${getStringFromBundle("test")}")
        Log.i("BasicViewModel", "commonLog - onCreate: ${getStringFromIntent("test")}, ${getIntFromIntent("test2")}")
        Log.i("BasicViewModel", "commonLog - onCreate: ${Arrays.toString(getStringArrayFromIntent("test3"))}")
    }
}