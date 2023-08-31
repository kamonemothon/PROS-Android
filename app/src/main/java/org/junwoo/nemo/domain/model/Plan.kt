package org.junwoo.nemo.domain.model

data class Plan(
    val departureDateTime: String,
    val thumbnail: String,
    val id: Int,
    val public: Boolean,
    val title: String,
    val user: User
)