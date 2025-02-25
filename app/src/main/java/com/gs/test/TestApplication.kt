package com.gs.test

import com.gs.core.GsApplication

class TestApplication : GsApplication() {

    override fun fixWebView(packageName: String) {
        super.fixWebView(getPackageName())
    }

    override fun setupAdMob(isDebug: Boolean) {
        super.setupAdMob(BuildConfig.DEBUG)
    }
}