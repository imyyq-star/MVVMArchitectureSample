package com.imyyq.sample

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import com.imyyq.mvvm.base.BaseModel
import com.imyyq.mvvm.base.BaseViewModel
import com.imyyq.mvvm.binding.command.BindingConsumer
import com.imyyq.mvvm.binding.viewadapter.listview.ListViewScrollDataWrapper
import me.tatarka.bindingcollectionadapter2.ItemBinding
import me.tatarka.bindingcollectionadapter2.OnItemBind
import me.tatarka.bindingcollectionadapter2.itembindings.OnItemBindClass
import me.tatarka.bindingcollectionadapter2.map


class ListViewViewModel(app: Application) : BaseViewModel<BaseModel>(app) {
    // 一种数据类型
    val items: ObservableList<String> = ObservableArrayList()
    // 多种数据类型
    val itemAny: ObservableList<Any> = ObservableArrayList()

    // item 的类型只有一个
    var itemBinding: ItemBinding<String>

    // item 的类型有多个
    val onItemBind: OnItemBind<String> =
        OnItemBind { itemBinding, position, item ->
            // 可以根据 position 来判断 item 的类型
            if (position % 2 == 0) {
                itemBinding.set(
                    BR.item,
                    R.layout.item
                )
            } else {
                itemBinding.set(
                    BR.item,
                    R.layout.item2
                )
            }
        }

    // 根据不同的数据类型使用不同的布局，使用 bindingAdapter-ktx 简化代码
    val multipleItems = OnItemBindClass<Any>().apply {
        map<String>(BR.item, R.layout.item)
        map<Int>(BR.item, R.layout.item3)
    }

    init {
        for (i in 0..10) {
            items.add("item $i")
        }
        for (i in 0..10) {
            itemAny.add("item $i")
            itemAny.add(i)
        }

        // 可以延迟设置 adapter
        itemBinding = ItemBinding.of(BR.item, R.layout.item)
    }

    val onScrollStateChangedCommand = BindingConsumer<Int> {
        Log.i("ListViewViewModel", "commonLog - : $it")
    }

    val onScrollChangeCommand = BindingConsumer<ListViewScrollDataWrapper> {
        Log.i("ListViewViewModel", "commonLog - : $it")
    }
}