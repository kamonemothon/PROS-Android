package org.junwoo.nemo.data.model.dto

import com.google.gson.annotations.SerializedName

data class PlaceDto(
    val buildingNumber: String,
    val city: String,
    val district: String,
    @SerializedName("fileURL")
    val thumbnail: String,
    val id: Int,
    val neighborhood: String,
    @SerializedName("place_name")
    val placeName: String,
    val phone: String,
    val street: String,
    val type: String,
    @SerializedName("x")
    val latitude: String,
    @SerializedName("y")
    val longitude: String
)