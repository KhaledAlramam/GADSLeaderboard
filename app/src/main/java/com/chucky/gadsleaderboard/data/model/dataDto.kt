package com.chucky.gadsleaderboard.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataDTO(
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("hours")
    @Expose
    val hours: Int = 0,
    @SerializedName("score")
    @Expose
    var score: Int = 0,
    @SerializedName("country")
    @Expose
    val country: String,
    @SerializedName("badgeUrl")
    @Expose
    val badgeUrl: String
)