package org.junwoo.nemo.data.repository

import org.junwoo.nemo.data.service.UserService
import org.junwoo.nemo.domain.model.User
import org.junwoo.nemo.domain.repository.UserRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(
    private val userService: UserService
) : UserRepository {
    override suspend fun getUserId(id: Long): User = dummyUser
}

val dummyUser =
    User(
        createdDate = "2023.08.31 15:11",
        modifiedDate = "2023.08.31 15:11",
        id = 1,
        name = "유지나",
        email = "wlskb@naver.com",
        nickname = "지나나나",
        password = "jinajjang",
        address = "서울 동대문구 휘경동 망우로"

    )