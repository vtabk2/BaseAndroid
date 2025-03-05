package com.gs.core.ui.activity

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.content.ContextCompat
import com.core.gsmvvm.ui.activity.BaseMVVMActivity
import com.gs.core.databinding.ActivityPermissionBinding

class PermissionActivity : BaseMVVMActivity<ActivityPermissionBinding>() {

    override fun getViewBinding(): ActivityPermissionBinding {
        return ActivityPermissionBinding.inflate(layoutInflater)
    }

    fun hasPermission(permId: Int = PERMISSION_WRITE_STORAGE, hasFull: Boolean = false): Boolean {
        return when (permId) {
            PERMISSION_WRITE_STORAGE -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_MEDIA_IMAGES) == PackageManager.PERMISSION_GRANTED)) {
                    // Full access on Android 13 (API level 33) or higher
                    true
                } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE && ContextCompat.checkSelfPermission(this, Manifest.permission.READ_MEDIA_VISUAL_USER_SELECTED) == PackageManager.PERMISSION_GRANTED) {
                    // Partial access on Android 14 (API level 34) or higher
                    !hasFull
                } else {
                    // Full access up to Android 12 (API level 32)
                    // Access denied
                    ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                }
            }

            else -> {
                ContextCompat.checkSelfPermission(this, getPermissionString(permId)) == PackageManager.PERMISSION_GRANTED
            }
        }
    }

    fun getPermissionString(id: Int = PERMISSION_CAMERA) = when (id) {
        PERMISSION_CAMERA -> Manifest.permission.CAMERA
        else -> ""
    }

    companion object {
        // permissions
        const val PERMISSION_WRITE_STORAGE = 1
        const val PERMISSION_CAMERA = 2
    }
}