package com.imyyq.sample.vp

import android.app.Application
import androidx.databinding.ObservableArrayList
import com.imyyq.mvvm.base.BaseModel
import com.imyyq.mvvm.base.BaseViewModel
import com.imyyq.sample.R
import me.tatarka.bindingcollectionadapter2.BR
import me.tatarka.bindingcollectionadapter2.itemBindingOf

class ViewPagerViewModel(app: Application) : BaseViewModel<BaseModel>(app) {
    val pageItem = itemBindingOf<String>(BR.item, R.layout.item_page)

    val items = ObservableArrayList<String>().apply {
        for (i in 0 until 3) {
            add("item $i")
        }
    }
}