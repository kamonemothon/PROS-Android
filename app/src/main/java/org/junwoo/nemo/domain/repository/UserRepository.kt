package org.junwoo.nemo.domain.repository

import org.junwoo.nemo.domain.model.User

interface UserRepository {
    suspend fun getUserId(id: Long): User
}