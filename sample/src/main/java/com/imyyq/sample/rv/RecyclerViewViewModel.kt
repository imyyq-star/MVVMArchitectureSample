package com.imyyq.sample.rv

import android.app.Application
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.GridLayoutManager
import com.imyyq.mvvm.base.AppBarBaseViewModel
import com.imyyq.mvvm.base.BaseModel
import com.imyyq.sample.BR
import com.imyyq.sample.R
import com.imyyq.sample.app.MyCommonAppBarProcessor2
import me.tatarka.bindingcollectionadapter2.itembindings.OnItemBindClass
import me.tatarka.bindingcollectionadapter2.map

class RecyclerViewViewModel(app: Application) : AppBarBaseViewModel<BaseModel, MyCommonAppBarProcessor2>(app) {
    val observableList = ObservableArrayList<Any>()

    val multipleItems = OnItemBindClass<Any>().apply {
        map<RvItemViewModel>(BR.viewModel, R.layout.rv_item)
        map<String>(BR.item, R.layout.item)
    }

    // 决定每个 item 占据屏幕的几列
    val spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
        override fun getSpanSize(position: Int): Int {
            if (observableList[position] is String) {
                return 2
            }
            return 6
        }
    }

    init {
        for (i in 0..10) {
            observableList.add("item $i")
            if (i % 2 == 0) {
                observableList.add(RvItemViewModel(this, "rv item $i"))
            }
        }
    }
}