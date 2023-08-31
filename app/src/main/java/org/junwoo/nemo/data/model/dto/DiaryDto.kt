package org.junwoo.nemo.data.model.dto

import com.google.gson.annotations.SerializedName

data class DiaryDto(
    val content: String,
    val createdDate: String,
    @SerializedName("fileURL")
    val thumbnail: String,
    val id: Long,
    val modifiedDate: String,
    val place: PlaceDto,
    val user: UserDto
)