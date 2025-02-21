package com.gs.test

import android.os.Bundle
import com.gs.core.admob.natives.NativeUtils
import com.gs.core.ui.activity.BaseVMActivity
import com.gs.test.databinding.ActivityMainBinding

class MainActivity : BaseVMActivity<ActivityMainBinding>() {

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun setupSystemUi(show: Boolean) {
        super.setupSystemUi(false)
    }

    override fun initViews(savedInstanceState: Bundle?) {
        super.initViews(savedInstanceState)

        NativeUtils.loadNativeAds(this, this, isVip = false, callback = { nativeAd ->
            nativeAd?.let {
                bindingView.nativeFrame1.setNativeAd(it)
                bindingView.nativeFrame2.setNativeAd(it)
                bindingView.nativeLanguage.setNativeAd(it)
                bindingView.nativeShare.setNativeAd(it)
                bindingView.nativeSticker.setNativeAd(it)
                bindingView.nativeAlbum.setNativeAd(it)
                bindingView.nativeFont.setNativeAd(it)
                bindingView.nativeTemplate.setNativeAd(it)
            }
        })
    }
}