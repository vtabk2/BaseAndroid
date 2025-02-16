package com.gs.core.utils.result

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

class RequestPermissionContract : ActivityResultContract<String, Pair<String, Boolean>>() {
    private var input: String = Manifest.permission.CAMERA

    override fun createIntent(context: Context, input: String): Intent {
        this.input = input

        return Intent(ActivityResultContracts.RequestMultiplePermissions.ACTION_REQUEST_PERMISSIONS)
            .putExtra(ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSIONS, arrayOf(input))
    }

    override fun parseResult(resultCode: Int, intent: Intent?): Pair<String, Boolean> {
        if (intent == null || resultCode != Activity.RESULT_OK) return Pair(input, false)
        val grantResults = intent.getIntArrayExtra(ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSION_GRANT_RESULTS)
        return Pair(input, grantResults?.any { result ->
            result == PackageManager.PERMISSION_GRANTED
        } == true)
    }
}