package com.gs.test

import android.os.Bundle
import android.util.Log
import com.core.gsadmob.natives.AdsMode
import com.core.gsadmob.natives.NativeUtils
import com.core.gsadmob.natives.view.BaseNativeAdView
import com.gs.core.ui.activity.BaseMVVMActivity
import com.gs.core.utils.network.NetworkUtils
import com.gs.test.databinding.ActivityMainBinding

class MainActivity : BaseMVVMActivity<ActivityMainBinding>() {

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

        NetworkUtils.hasInternetAccessCheck(doTask = {
            Log.d("TAG5", "initViews: success")
        }, doException = { networkError ->
            Log.d("TAG5", "initViews: networkError = " + networkError.name)
        }, activity = this)
    }
}