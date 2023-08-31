package org.junwoo.nemo.domain.repository

import kotlinx.coroutines.flow.Flow
import org.junwoo.nemo.domain.model.User

interface UserRepository {
    fun getUserId(id: Long): Flow<User>
}