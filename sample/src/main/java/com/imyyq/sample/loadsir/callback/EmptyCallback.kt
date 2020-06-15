package com.imyyq.sample.loadsir.callback

import com.imyyq.sample.R
import com.kingja.loadsir.callback.Callback

class EmptyCallback: Callback() {
    override fun onCreateView(): Int {
        return R.layout.load_sir_callback_empty
    }
}