package com.gs.test

import android.os.Bundle
import com.core.gsadmob.natives.AdsMode
import com.core.gsadmob.natives.NativeUtils
import com.core.gsadmob.natives.view.BaseNativeAdView
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
        TestApplication.applicationContext().initMobileAds()

        bindingView.nativeTest1.applyBuilder(BaseNativeAdView.Builder().apply {
            adsMode = AdsMode.VIP
        })

        NativeUtils.loadNativeAds(this, this, isVip = false, callbackStart = {
            bindingView.nativeTest1.startShimmer()
        }, callback = { nativeAd ->
            bindingView.nativeTest1.setNativeAd(nativeAd)
        })
    }
}