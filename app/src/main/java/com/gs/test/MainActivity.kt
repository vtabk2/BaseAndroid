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
        super.setupSystemUi(show = true)
    }

    override fun initViews(savedInstanceState: Bundle?) {
        super.initViews(savedInstanceState)

        NativeUtils.loadNativeAds(this, this, isVip = false, callbackStart = {
            bindingView.nativeFrame1.startShimmer()
            bindingView.nativeFrame2.startShimmer()
            bindingView.nativeLanguage.startShimmer()
            bindingView.nativeShare.startShimmer()
            bindingView.nativeSticker.startShimmer()
            bindingView.nativeAlbum.startShimmer()
            bindingView.nativeFont.startShimmer()
            bindingView.nativeTemplate.startShimmer()
            bindingView.nativeCustom.startShimmer()
        }, callback = { nativeAd ->
            bindingView.nativeFrame1.setNativeAd(nativeAd)
            bindingView.nativeFrame2.setNativeAd(nativeAd)
            bindingView.nativeLanguage.setNativeAd(nativeAd)
            bindingView.nativeShare.setNativeAd(nativeAd)
            bindingView.nativeSticker.setNativeAd(nativeAd)
            bindingView.nativeAlbum.setNativeAd(nativeAd)
            bindingView.nativeFont.setNativeAd(nativeAd)
            bindingView.nativeTemplate.setNativeAd(nativeAd)
            bindingView.nativeCustom.setNativeAd(nativeAd)
        })
    }
}