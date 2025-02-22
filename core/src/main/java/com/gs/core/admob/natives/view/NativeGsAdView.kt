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
import com.gs.core.databinding.AdNativeAlbumBinding
import com.gs.core.databinding.AdNativeFontBinding
import com.gs.core.databinding.AdNativeFrameBinding
import com.gs.core.databinding.AdNativeLanguageBinding
import com.gs.core.databinding.AdNativeShareBinding
import com.gs.core.databinding.AdNativeStickerBinding
import com.gs.core.databinding.AdNativeTemplateBinding

class NativeGsAdView(context: Context, attrs: AttributeSet? = null) : BaseNativeAdView(context, attrs) {
    private var adNativeAlbumBinding: AdNativeAlbumBinding? = null
    private var adNativeFontBinding: AdNativeFontBinding? = null
    private var adNativeFrameBinding: AdNativeFrameBinding? = null
    private var adNativeLanguageBinding: AdNativeLanguageBinding? = null
    private var adNativeShareBinding: AdNativeShareBinding? = null
    private var adNativeStickerBinding: AdNativeStickerBinding? = null
    private var adNativeTemplateBinding: AdNativeTemplateBinding? = null

    override val titleView: AppCompatTextView? by lazy {
        when (adsMode) {
            AdsMode.ALBUM -> adNativeAlbumBinding?.adHeadlineAlbum
            AdsMode.FONT -> adNativeFontBinding?.adHeadlineFont
            AdsMode.FRAME -> adNativeFrameBinding?.adHeadlineFrame
            AdsMode.LANGUAGE -> adNativeLanguageBinding?.adHeadlineLanguage
            AdsMode.SHARE -> adNativeShareBinding?.adHeadlineShare
            AdsMode.STICKER -> adNativeStickerBinding?.adHeadlineSticker
            AdsMode.TEMPLATE -> adNativeTemplateBinding?.adHeadlineTemplate
            AdsMode.CUSTOM -> customView?.findViewById(builder.adHeadlineId)
            else -> null
        }
    }

    override val subTitleView: AppCompatTextView? by lazy {
        when (adsMode) {
            AdsMode.ALBUM -> null
            AdsMode.FONT -> adNativeFontBinding?.adBodyFont
            AdsMode.FRAME -> adNativeFrameBinding?.adBodyFrame
            AdsMode.LANGUAGE -> adNativeLanguageBinding?.adBodyLanguage
            AdsMode.SHARE -> adNativeShareBinding?.adBodyShare
            AdsMode.STICKER -> adNativeStickerBinding?.adBodySticker
            AdsMode.TEMPLATE -> adNativeTemplateBinding?.adBodyTemplate
            AdsMode.CUSTOM -> customView?.findViewById(builder.adBodyId)
            else -> null
        }
    }

    override val starView: RatingBar? by lazy {
        when (adsMode) {
            AdsMode.ALBUM -> adNativeAlbumBinding?.adStarsAlbum
            AdsMode.FONT -> adNativeFontBinding?.adStarsFont
            AdsMode.FRAME -> adNativeFrameBinding?.adStarsFrame
            AdsMode.LANGUAGE -> adNativeLanguageBinding?.adStarsLanguage
            AdsMode.SHARE -> adNativeShareBinding?.adStarsShare
            AdsMode.STICKER -> adNativeStickerBinding?.adStarsSticker
            AdsMode.TEMPLATE -> adNativeTemplateBinding?.adStarsTemplate
            AdsMode.CUSTOM -> customView?.findViewById(builder.adStarsId)
            else -> null
        }
    }

    override val iconView: ImageView? by lazy {
        when (adsMode) {
            AdsMode.ALBUM -> adNativeAlbumBinding?.adAppIconAlbum
            AdsMode.FONT -> adNativeFontBinding?.adAppIconFont
            AdsMode.FRAME -> adNativeFrameBinding?.adAppIconFrame
            AdsMode.LANGUAGE -> adNativeLanguageBinding?.adAppIconLanguage
            AdsMode.SHARE -> adNativeShareBinding?.adAppIconShare
            AdsMode.STICKER -> adNativeStickerBinding?.adAppIconSticker
            AdsMode.TEMPLATE -> adNativeTemplateBinding?.adAppIconTemplate
            AdsMode.CUSTOM -> customView?.findViewById(builder.adAppIconId)
            else -> null
        }
    }

    override val callActionButtonView: AppCompatTextView? by lazy {
        when (adsMode) {
            AdsMode.ALBUM -> adNativeAlbumBinding?.adCallToActionAlbum
            AdsMode.FONT -> adNativeFontBinding?.adCallToActionFont
            AdsMode.FRAME -> adNativeFrameBinding?.adCallToActionFrame
            AdsMode.LANGUAGE -> adNativeLanguageBinding?.adCallToActionLanguage
            AdsMode.SHARE -> adNativeShareBinding?.adCallToActionShare
            AdsMode.STICKER -> adNativeStickerBinding?.adCallToActionSticker
            AdsMode.TEMPLATE -> adNativeTemplateBinding?.adCallToActionTemplate
            AdsMode.CUSTOM -> customView?.findViewById(builder.adCallToActionId)
            else -> null
        }
    }

    override val adView: NativeAdView? by lazy {
        when (adsMode) {
            AdsMode.ALBUM -> adNativeAlbumBinding?.adViewAlbum
            AdsMode.FONT -> adNativeFontBinding?.adViewFont
            AdsMode.FRAME -> adNativeFrameBinding?.adViewFrame
            AdsMode.LANGUAGE -> adNativeLanguageBinding?.adViewLanguage
            AdsMode.SHARE -> adNativeShareBinding?.adViewShare
            AdsMode.STICKER -> adNativeStickerBinding?.adViewSticker
            AdsMode.TEMPLATE -> adNativeTemplateBinding?.adViewTemplate
            AdsMode.CUSTOM -> customView?.findViewById(builder.adViewId)
            else -> null
        }
    }

    override val mediaView: MediaView? by lazy {
        when (adsMode) {
            AdsMode.ALBUM -> null
            AdsMode.FONT -> null
            AdsMode.FRAME -> adNativeFrameBinding?.adMediaFrame
            AdsMode.LANGUAGE -> adNativeLanguageBinding?.adMediaLanguage
            AdsMode.SHARE -> adNativeShareBinding?.adMediaShare
            AdsMode.STICKER -> null
            AdsMode.TEMPLATE -> null
            AdsMode.CUSTOM -> customView?.findViewById(builder.adMediaViewId)
            else -> null
        }
    }

    override val shimmerView: ShimmerFrameLayout? by lazy {
        when (adsMode) {
            AdsMode.ALBUM -> adNativeAlbumBinding?.albumShimmer?.adViewAlbumShimmer
            AdsMode.FONT -> null
            AdsMode.FRAME -> adNativeFrameBinding?.frameShimmer?.adViewFrameShimmer
            AdsMode.LANGUAGE -> adNativeLanguageBinding?.languageShimmer?.adViewLanguageShimmer
            AdsMode.SHARE -> adNativeShareBinding?.shareShimmer?.adViewShareShimmer
            AdsMode.STICKER -> null
            AdsMode.TEMPLATE -> null
            AdsMode.CUSTOM -> customView?.findViewById(builder.adShimmerId)
            else -> null
        }
    }

    init {
        when (adsMode) {
            AdsMode.ALBUM -> adNativeAlbumBinding = AdNativeAlbumBinding.inflate(layoutInflater, this, true)
            AdsMode.FONT -> adNativeFontBinding = AdNativeFontBinding.inflate(layoutInflater, this, true)
            AdsMode.FRAME -> adNativeFrameBinding = AdNativeFrameBinding.inflate(layoutInflater, this, true)
            AdsMode.LANGUAGE -> adNativeLanguageBinding = AdNativeLanguageBinding.inflate(layoutInflater, this, true)
            AdsMode.SHARE -> adNativeShareBinding = AdNativeShareBinding.inflate(layoutInflater, this, true)
            AdsMode.STICKER -> adNativeStickerBinding = AdNativeStickerBinding.inflate(layoutInflater, this, true)
            AdsMode.TEMPLATE -> adNativeTemplateBinding = AdNativeTemplateBinding.inflate(layoutInflater, this, true)
            AdsMode.CUSTOM -> {
                customView = layoutInflater.inflate(builder.adLayoutId, null)
                addView(customView)
            }
            else -> {

            }
        }
    }
}