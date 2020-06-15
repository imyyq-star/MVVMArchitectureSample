package com.imyyq.sample.rv

import android.app.Application
import androidx.databinding.ObservableArrayList
import com.imyyq.mvvm.base.BaseModel
import com.imyyq.mvvm.base.BaseViewModel
import com.imyyq.sample.BR
import com.imyyq.sample.R
import me.tatarka.bindingcollectionadapter2.itembindings.OnItemBindClass
import me.tatarka.bindingcollectionadapter2.map

class RecyclerViewViewModel(app: Application) : BaseViewModel<BaseModel>(app) {
    val observableList = ObservableArrayList<RvItemViewModel>()

    val multipleItems = OnItemBindClass<Any>().apply {
        map<RvItemViewModel>(BR.item, R.layout.item)
        map<String>(BR.item, R.layout.item)
    }

    init {
        for (i in 0..10) {
            
        }
    }
}