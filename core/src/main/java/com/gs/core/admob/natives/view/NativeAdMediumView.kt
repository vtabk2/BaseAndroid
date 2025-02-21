package com.gs.core.admob.natives.view

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.RatingBar
import androidx.appcompat.widget.AppCompatTextView
import com.facebook.shimmer.ShimmerFrameLayout
import com.google.android.gms.ads.nativead.MediaView
import com.google.android.gms.ads.nativead.NativeAdView
import com.gs.core.admob.natives.AdsMode
import com.gs.core.databinding.AdNativeMediumFrameBinding
import com.gs.core.databinding.AdNativeMediumLanguageBinding
import com.gs.core.databinding.AdNativeMediumShareBinding
import com.gs.core.databinding.AdNativeMediumStickerBinding

class NativeAdMediumView(context: Context, attrs: AttributeSet? = null) : BaseNativeAdView(context, attrs) {
    private var adNativeMediumStickerBinding: AdNativeMediumStickerBinding? = null
    private var adNativeMediumFrameBinding: AdNativeMediumFrameBinding? = null
    private var adNativeMediumShareBinding: AdNativeMediumShareBinding? = null
    private var adNativeMediumLanguageBinding: AdNativeMediumLanguageBinding? = null

    override val titleView: AppCompatTextView? by lazy {
        when (adsMode) {
            AdsMode.STICKER -> adNativeMediumStickerBinding?.adHeadlineSticker
            AdsMode.FRAME -> adNativeMediumFrameBinding?.adHeadlineFrame
            AdsMode.LANGUAGE -> adNativeMediumLanguageBinding?.adHeadlineLanguage
            else -> adNativeMediumShareBinding?.adHeadlineShare
        }
    }

    override val subTitleView: AppCompatTextView? by lazy {
        when (adsMode) {
            AdsMode.STICKER -> adNativeMediumStickerBinding?.adBodySticker
            AdsMode.FRAME -> adNativeMediumFrameBinding?.adBodyFrame
            AdsMode.LANGUAGE -> adNativeMediumLanguageBinding?.adBodyLanguage
            else -> adNativeMediumShareBinding?.adBodyShare
        }
    }

    override val starView: RatingBar? by lazy {
        when (adsMode) {
            AdsMode.STICKER -> adNativeMediumStickerBinding?.adStarsSticker
            AdsMode.FRAME -> adNativeMediumFrameBinding?.adStarsFrame
            AdsMode.LANGUAGE -> adNativeMediumLanguageBinding?.adStarsLanguage
            else -> adNativeMediumShareBinding?.adStarsShare
        }
    }

    override val iconView: ImageView? by lazy {
        when (adsMode) {
            AdsMode.STICKER -> adNativeMediumStickerBinding?.adAppIconSticker
            AdsMode.FRAME -> adNativeMediumFrameBinding?.adAppIconFrame
            AdsMode.LANGUAGE -> adNativeMediumLanguageBinding?.adAppIconLanguage
            else -> adNativeMediumShareBinding?.adAppIconShare
        }
    }

    override val callActionButtonView: AppCompatTextView? by lazy {
        when (adsMode) {
            AdsMode.STICKER -> adNativeMediumStickerBinding?.adCallToActionSticker
            AdsMode.FRAME -> adNativeMediumFrameBinding?.adCallToActionFrame
            AdsMode.LANGUAGE -> adNativeMediumLanguageBinding?.adCallToActionLanguage
            else -> adNativeMediumShareBinding?.adCallToActionShare
        }
    }

    override val adView: NativeAdView? by lazy {
        when (adsMode) {
            AdsMode.STICKER -> adNativeMediumStickerBinding?.adViewSticker
            AdsMode.FRAME -> adNativeMediumFrameBinding?.adViewFrame
            AdsMode.LANGUAGE -> adNativeMediumLanguageBinding?.adViewLanguage
            else -> adNativeMediumShareBinding?.adViewShare
        }
    }

    override val mediaView: MediaView? by lazy {
        when (adsMode) {
            AdsMode.STICKER -> null
            AdsMode.FRAME -> adNativeMediumFrameBinding?.adMediaFrame
            AdsMode.LANGUAGE -> adNativeMediumLanguageBinding?.adMediaLanguage
            else -> adNativeMediumShareBinding?.adMediaShare
        }
    }

    override val shimmerView: ShimmerFrameLayout? by lazy {
        when (adsMode) {
            AdsMode.FRAME -> adNativeMediumFrameBinding?.frameShimmer?.adViewFrameShimmer
            AdsMode.LANGUAGE -> adNativeMediumLanguageBinding?.languageShimmer?.adViewLanguageShimmer
            else -> null
        }
    }

    init {
        when (adsMode) {
            AdsMode.STICKER -> adNativeMediumStickerBinding = AdNativeMediumStickerBinding.inflate(layoutInflater, this, true)
            AdsMode.FRAME -> adNativeMediumFrameBinding = AdNativeMediumFrameBinding.inflate(layoutInflater, this, true)
            AdsMode.LANGUAGE -> adNativeMediumLanguageBinding = AdNativeMediumLanguageBinding.inflate(layoutInflater, this, true)
            else -> adNativeMediumShareBinding = AdNativeMediumShareBinding.inflate(layoutInflater, this, true)
        }
    }
}