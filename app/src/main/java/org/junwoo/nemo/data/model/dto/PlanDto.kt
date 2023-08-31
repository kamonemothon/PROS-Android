package org.junwoo.nemo.data.model.dto

import com.google.gson.annotations.SerializedName

data class PlanDto(
    val departureDateTime: String,
    @SerializedName("fileURL")
    val thumbnail: String,
    val id: Int,
    val public: Boolean,
    val title: String,
    val user: UserDto
)