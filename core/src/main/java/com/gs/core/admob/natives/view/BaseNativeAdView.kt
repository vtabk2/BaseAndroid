package com.gs.core.admob.natives.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.RatingBar
import androidx.appcompat.widget.AppCompatTextView
import com.facebook.shimmer.ShimmerFrameLayout
import com.google.android.gms.ads.nativead.MediaView
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdView
import com.gs.core.R
import com.gs.core.admob.natives.AdsMode
import com.gs.core.utils.extensions.gone
import com.gs.core.utils.extensions.invisible
import com.gs.core.utils.extensions.visible
import java.util.Locale

abstract class BaseNativeAdView(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {
    val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    abstract val titleView: AppCompatTextView?
    abstract val subTitleView: AppCompatTextView?
    abstract val starView: RatingBar?
    abstract val iconView: ImageView?
    abstract val callActionButtonView: AppCompatTextView?
    abstract val adView: NativeAdView?
    abstract val mediaView: MediaView?
    abstract val shimmerView: ShimmerFrameLayout?

    private var nativeAd: NativeAd? = null
    var adsMode = AdsMode.ALBUM

    init {
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.BaseNativeAdView)
            adsMode = AdsMode.entries.toTypedArray()[typedArray.getInt(R.styleable.BaseNativeAdView_ads_mode, 0)]
            typedArray.recycle()
        }
    }

    open fun setNativeAd(nativeAd: NativeAd?) {
        stopShimmer()
        if (nativeAd == null) {
            gone()
            return
        }
        visible()

        val icon = nativeAd.icon
        val title = nativeAd.headline
        val callAction = nativeAd.callToAction
        val subTitle = nativeAd.body
        if (icon != null) {
            iconView?.setImageDrawable(icon.drawable)
            iconView?.visible()
        } else {
            iconView?.gone()
        }
        if (subTitle != null) {
            subTitleView?.text = subTitle
            subTitleView?.visible()
        } else {
            subTitleView?.invisible()
        }
        if (title != null) {
            titleView?.text = title
            titleView?.visible()
        } else {
            titleView?.invisible()
        }
        nativeAd.starRating?.let { starRating ->
            starView?.rating = starRating.toFloat()
            starView?.visible()
        } ?: run {
            if (adsMode == AdsMode.STICKER) {
                if (icon != null) {
                    starView?.invisible()
                } else {
                    starView?.gone()
                }
            } else {
                starView?.invisible()
            }
        }
        if (callAction != null) {
            callActionButtonView?.text = callAction.lowercase(Locale.getDefault()).replaceFirstChar { it.titlecase() }
            callActionButtonView?.visible()
        } else {
            callActionButtonView?.gone()
        }
        if (mediaView != null) {
            adView?.mediaView = mediaView
        }
        adView?.callToActionView = callActionButtonView
        adView?.headlineView = titleView
        adView?.bodyView = subTitleView
        adView?.setNativeAd(nativeAd)
    }

    fun updateCallActionButton(resId: Int) {
        callActionButtonView?.setBackgroundResource(resId)
    }

    fun destroy() {
        nativeAd?.destroy()
    }

    fun startShimmer() {
        shimmerView?.visible()
        shimmerView?.startShimmer()
    }

    fun stopShimmer() {
        shimmerView?.hideShimmer()
        shimmerView?.gone()
    }
}