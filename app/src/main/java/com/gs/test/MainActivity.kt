package com.gs.test

import com.gs.core.ui.activity.BaseVMActivity
import com.gs.test.databinding.ActivityMainBinding

class MainActivity : BaseVMActivity<ActivityMainBinding>() {

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun setupSystemUi(show: Boolean) {
        super.setupSystemUi(false)
    }
}