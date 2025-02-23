package com.gs.test

import android.os.Bundle
import com.gs.core.admob.natives.NativeUtils
import com.gs.core.ui.activity.BaseVMActivity
import com.gs.core.utils.extensions.gone
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

//        val builder = BaseNativeAdView.Builder().apply {
//            adLayoutId = R.layout.ad_native_test
//            adHeadlineId = R.id.ad_headline_test
//            adBodyId = 0
//            adStarsId = R.id.ad_stars_test
//            adAppIconId = R.id.ad_app_icon_test
//            adCallToActionId = R.id.ad_call_to_action_test
//            adViewId = R.id.ad_view_test
//            adMediaViewId = 0
//            adShimmerId = R.id.ad_view_test_shimmer
//        }
//        bindingView.nativeCustom.applyBuilder(builder)
//
        bindingView.nativeAlbum.gone()
        bindingView.nativeFont.gone()
        bindingView.nativeFrame1.gone()
        bindingView.nativeFrame2.gone()
        bindingView.nativeLanguage.gone()
        bindingView.nativeShare.gone()
        bindingView.nativeSticker.gone()
        bindingView.nativeTemplate.gone()
//        bindingView.nativeCustom.gone()

        NativeUtils.loadNativeAds(this, this, isVip = false, callbackStart = {
//            bindingView.nativeAlbum.startShimmer()
//            bindingView.nativeFont.startShimmer()
//            bindingView.nativeFrame1.startShimmer()
//            bindingView.nativeFrame2.startShimmer()
//            bindingView.nativeLanguage.startShimmer()
//            bindingView.nativeShare.startShimmer()
//            bindingView.nativeSticker.startShimmer()
//            bindingView.nativeTemplate.startShimmer()
            bindingView.nativeCustom.startShimmer()
        }, callback = { nativeAd ->
//            bindingView.nativeAlbum.setNativeAd(nativeAd)
//            bindingView.nativeFont.setNativeAd(nativeAd)
//            bindingView.nativeFrame1.setNativeAd(nativeAd)
//            bindingView.nativeFrame2.setNativeAd(nativeAd)
//            bindingView.nativeLanguage.setNativeAd(nativeAd)
//            bindingView.nativeShare.setNativeAd(nativeAd)
//            bindingView.nativeSticker.setNativeAd(nativeAd)
//            bindingView.nativeTemplate.setNativeAd(nativeAd)
            bindingView.nativeCustom.setNativeAd(nativeAd)
        })
    }
}