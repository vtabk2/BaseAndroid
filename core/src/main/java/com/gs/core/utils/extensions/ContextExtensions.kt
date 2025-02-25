package com.gs.core.utils.extensions

import android.content.Context
import com.gs.core.utils.preferences.GsDefaultConfig

object ContextExtensions {
    val Context.gsDefaultConfig: GsDefaultConfig get() = GsDefaultConfig.newInstance(applicationContext)
}