package org.junwoo.nemo.data.model.request

data class SearchRequest(
    val city: String,
    val district: String,
    val neighborhood: String,
    val street: String,
    val buildingNumber: String,
)