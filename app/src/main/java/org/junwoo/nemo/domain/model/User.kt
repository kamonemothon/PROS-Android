package org.junwoo.nemo.domain.model

data class User(
    val address: String,
    val createdDate: String,
    val email: String,
    val id: Int,
    val modifiedDate: String,
    val name: String,
    val nickname: String,
    val password: String
)