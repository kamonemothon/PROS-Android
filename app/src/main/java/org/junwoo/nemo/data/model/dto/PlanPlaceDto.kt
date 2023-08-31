package org.junwoo.nemo.data.model.dto

data class PlanPlaceDto(
    val id: Int,
    val place: PlaceDto,
    val placeOrder: String,
    val plan: PlanDto
)