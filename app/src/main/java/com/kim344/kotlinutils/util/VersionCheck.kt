package com.kim344.kotlinutils.util

import android.content.Context
import android.content.pm.PackageManager
import android.util.Log

fun getCurrentVersion(context: Context): String? {
    var version: String? = null

    try {
        val packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)
        version = packageInfo.versionName
    } catch (e: PackageManager.NameNotFoundException) {
    }

    return version
}

fun versionCompare(appVersion : String?, serverVersion : String?) : Boolean? {
    if (appVersion != null && serverVersion != null) {
        if (serverVersion.compareTo(appVersion) > 0){
            return false
        } else {
            return true
        }
    }
    return true
}