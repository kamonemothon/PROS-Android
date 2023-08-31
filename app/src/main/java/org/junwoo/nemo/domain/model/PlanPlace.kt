package org.junwoo.nemo.domain.model

data class PlanPlace(
    val id: Int,
    val place: Place,
    val placeOrder: Int,
    val plan: Plan
)