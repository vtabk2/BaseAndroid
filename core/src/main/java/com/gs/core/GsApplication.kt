package com.gs.core

import android.annotation.SuppressLint
import android.os.Build
import android.provider.Settings
import android.text.TextUtils
import android.webkit.WebView
import androidx.multidex.MultiDexApplication
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import com.gs.core.local.Lingver
import com.gs.core.local.store.PreferenceLocaleStore
import com.gs.core.utils.extensions.ContextExtensions.gsDefaultConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

abstract class GsApplication : MultiDexApplication() {
    private val deviceTestList = mutableListOf<String>()

    override fun onCreate() {
        super.onCreate()

        fixWebView("")

        setupAdMob(isDebug = false)

        setupLingver()
    }

    open fun fixWebView(packageName: String) {
        if (TextUtils.isEmpty(packageName)) return
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            val process = getProcessName()
            if (packageName != process) WebView.setDataDirectorySuffix(process)
        }
    }

    open fun setupAdMob(isDebug: Boolean) {
        if (isDebug) {
            deviceTestList.add(md5(getAndroidId()).uppercase())

            val requestConfiguration = RequestConfiguration.Builder()
                .setTestDeviceIds(deviceTestList)
                .build()
            MobileAds.setRequestConfiguration(requestConfiguration)
        }
    }

    private fun setupLingver() {
        // you can use this instance for DI or get it via Lingver.getInstance() later on
        Lingver.init(this, PreferenceLocaleStore(this))
        if (gsDefaultConfig.isGSFirstStartApp) {
            gsDefaultConfig.isGSFirstStartApp = false
            Lingver.getInstance().setFollowSystemLocale(this)
            // setup default start app
            setupDefaultStartApp()
        }
    }

    open fun setupDefaultStartApp() {}

    fun initMobileAds() {
        val backgroundScope = CoroutineScope(Dispatchers.IO)
        backgroundScope.launch {
            // Initialize the Google Mobile Ads SDK on a background thread.
            MobileAds.initialize(this@GsApplication) {}
        }
    }

    private fun md5(input: String): String {
        try {
            // Create MD5 Hash
            val digest = MessageDigest.getInstance("MD5")
            digest.update(input.toByteArray())
            val messageDigest = digest.digest()

            // Create Hex String
            val hexString = StringBuffer()
            for (i in messageDigest.indices) hexString.append(java.lang.String.format("%02X", 0xFF and messageDigest[i].toInt()))
            return hexString.toString()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
        return ""
    }

    @SuppressLint("HardwareIds")
    private fun getAndroidId(): String {
        return try {
            Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
        } catch (e: Exception) {
            ""
        }
    }
}