package com.kim344.kotlinutils.retrofit2

import com.google.gson.annotations.SerializedName

class Model {

    /* Init
    @SerializedName("has_more")
    var has_more: Boolean = false

    @SerializedName("quota_max")
    var quota_max: Int = 0

    @SerializedName("quota_remaining")
    var quota_remaining: Int = 0
     */

    data class VO(
        @SerializedName("has_more")
        var has_more: Boolean = false,

        @SerializedName("quota_max")
        var quota_max: Int = 0,

        @SerializedName("quota_remaining")
        var quota_remaining: Int = 0
    )

}