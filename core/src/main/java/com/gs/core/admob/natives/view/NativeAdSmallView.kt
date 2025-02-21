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
import com.gs.core.databinding.AdNativeSmallAlbumBinding
import com.gs.core.databinding.AdNativeSmallFontBinding
import com.gs.core.databinding.AdNativeSmallTemplateBinding

class NativeAdSmallView(context: Context, attrs: AttributeSet? = null) : BaseNativeAdView(context, attrs) {
    private var adNativeSmallFontBinding: AdNativeSmallFontBinding? = null
    private var adNativeSmallTemplateBinding: AdNativeSmallTemplateBinding? = null
    private var adNativeSmallAlbumBinding: AdNativeSmallAlbumBinding? = null

    override val titleView: AppCompatTextView? by lazy {
        when (adsMode) {
            AdsMode.FONT -> adNativeSmallFontBinding?.adHeadlineFont
            AdsMode.TEMPLATE -> adNativeSmallTemplateBinding?.adHeadlineTemplate
            else -> adNativeSmallAlbumBinding?.adHeadlineAlbum
        }
    }

    override val subTitleView: AppCompatTextView? by lazy {
        when (adsMode) {
            AdsMode.FONT -> adNativeSmallFontBinding?.adBodyFont
            AdsMode.TEMPLATE -> adNativeSmallTemplateBinding?.adBodyTemplate
            else -> null
        }
    }

    override val starView: RatingBar? by lazy {
        when (adsMode) {
            AdsMode.FONT -> adNativeSmallFontBinding?.adStarsFont
            AdsMode.TEMPLATE -> adNativeSmallTemplateBinding?.adStarsTemplate
            else -> adNativeSmallAlbumBinding?.adStarsAlbum
        }
    }

    override val iconView: ImageView? by lazy {
        when (adsMode) {
            AdsMode.FONT -> adNativeSmallFontBinding?.adAppIconFont
            AdsMode.TEMPLATE -> adNativeSmallTemplateBinding?.adAppIconTemplate
            else -> adNativeSmallAlbumBinding?.adAppIconAlbum
        }
    }

    override val callActionButtonView: AppCompatTextView? by lazy {
        when (adsMode) {
            AdsMode.FONT -> adNativeSmallFontBinding?.adCallToActionFont
            AdsMode.TEMPLATE -> adNativeSmallTemplateBinding?.adCallToActionTemplate
            else -> adNativeSmallAlbumBinding?.adCallToActionAlbum
        }
    }

    override val adView: NativeAdView? by lazy {
        when (adsMode) {
            AdsMode.FONT -> adNativeSmallFontBinding?.adViewFont
            AdsMode.TEMPLATE -> adNativeSmallTemplateBinding?.adViewTemplate
            else -> adNativeSmallAlbumBinding?.adViewAlbum
        }
    }

    override val mediaView: MediaView? = null

    override val shimmerView: ShimmerFrameLayout? = null

    init {
        when (adsMode) {
            AdsMode.FONT -> adNativeSmallFontBinding = AdNativeSmallFontBinding.inflate(layoutInflater, this, true)
            AdsMode.TEMPLATE -> adNativeSmallTemplateBinding = AdNativeSmallTemplateBinding.inflate(layoutInflater, this, true)
            else -> adNativeSmallAlbumBinding = AdNativeSmallAlbumBinding.inflate(layoutInflater, this, true)
        }
    }
}