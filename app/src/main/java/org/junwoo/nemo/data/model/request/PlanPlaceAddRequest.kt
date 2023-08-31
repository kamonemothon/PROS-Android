package org.junwoo.nemo.data.model.request

import com.google.gson.annotations.SerializedName

data class PlanPlaceAddRequest(
    @SerializedName("planId")
    val planId: Long,
    @SerializedName("placeId")
    val placeId: Long
)