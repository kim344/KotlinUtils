package com.kim344.kotlinutils.util

import android.util.Base64

class Base64Utils {
    /**
     * Base64 인코딩
     */
    fun getBase64encode(content: String): String? {
        return Base64.encodeToString(content.toByteArray(), 0)
    }

    /**
     * Base64 디코딩
     */
    fun getBase64decode(content: String?): String? {
        return String(Base64.decode(content, 0))
    }
}