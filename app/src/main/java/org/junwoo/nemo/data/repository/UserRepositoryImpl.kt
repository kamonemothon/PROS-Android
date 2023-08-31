package org.junwoo.nemo.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.junwoo.nemo.data.service.UserService
import org.junwoo.nemo.data.mapper.toUser
import org.junwoo.nemo.domain.model.User
import org.junwoo.nemo.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userService: UserService
): UserRepository {
    override fun getUserId(id: Long): Flow<User> = flow {
        val user = userService.getUserId(id)
        emit(user.toUser())
    }
}