package org.junwoo.nemo.domain.model

data class Place(
    val buildingNumber: String,
    val city: String,
    val district: String,
    val thumbnail: String,
    val id: Int,
    val neighborhood: String,
    val placeName: String,
    val street: String,
    val type: LocationType,
    val latitude: Double,
    val longitude: Double
)