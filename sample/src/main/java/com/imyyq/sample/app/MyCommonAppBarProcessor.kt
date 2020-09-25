package com.imyyq.sample.app

import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.imyyq.mvvm.base.IAppBarProcessor

class MyCommonAppBarProcessor : IAppBarProcessor {
    // 标题
    val title = MutableLiveData<String>("我是默认标题")

    // 右边的按钮点击
    val onAppBarRightBtnClick = ObservableField<View.OnClickListener>()

    // 左边的按钮点击，如果你的控件使用 commonAppBarBackBtnId 这个 id，那么默认事件是结束掉界面
    val onAppBarLeftBtnClick = ObservableField<View.OnClickListener>()
}