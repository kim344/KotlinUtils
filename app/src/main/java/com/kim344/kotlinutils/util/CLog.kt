package com.kim344.kotlinutils.util

import android.util.Log
import com.kim344.kotlinutils.BuildConfig

class CLog {

    private val TAG = "SUDO"

    fun v(msg: String) {
        if (BuildConfig.DEBUG) {
            Log.v(TAG, buildLogMsg(msg))
        }
    }

    fun d(msg: String) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, buildLogMsg(msg))
        }
    }

    fun i(msg: String) {
        if (BuildConfig.DEBUG) {
            Log.i(TAG, buildLogMsg(msg))
        }
    }

    fun w(msg: String) {
        if (BuildConfig.DEBUG) {
            Log.w(TAG, buildLogMsg(msg))
        }
    }

    fun e(msg: String) {
        if (BuildConfig.DEBUG) {
            Log.e(TAG, buildLogMsg(msg))
        }
    }

    private fun buildLogMsg(message: String?): String {
        val stackTraceElement =
            Thread.currentThread().stackTrace[4]
        val stringBuilder = StringBuilder()
        stringBuilder.append("[")
        stringBuilder.append(stackTraceElement.fileName.replace(".java", ""))
        stringBuilder.append("::")
        stringBuilder.append(stackTraceElement.methodName)
        stringBuilder.append("]")
        stringBuilder.append(message)
        return stringBuilder.toString()
    }

}