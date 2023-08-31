package org.junwoo.nemo.data.model.dto

data class UserDto(
    val address: String,
    val createdDate: String,
    val email: String,
    val id: Int,
    val modifiedDate: String,
    val name: String,
    val nickname: String,
    val password: String
)