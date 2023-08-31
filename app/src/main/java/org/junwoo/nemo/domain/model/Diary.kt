package org.junwoo.nemo.domain.model

data class Diary(
    val content: String,
    val createdDate: String,
    val thumbnail: String,
    val id: Long,
    val modifiedDate: String,
    val place: Place,
    val user: User
)