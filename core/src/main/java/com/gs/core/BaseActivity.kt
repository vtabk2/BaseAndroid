package com.gs.core

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseVMActivity<B : ViewBinding> : AppCompatActivity() {
    lateinit var bindingView: B
    abstract fun getViewBinding(): B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingView = getViewBinding()
        val view = bindingView.root
        setContentView(view)
    }
}