package org.junwoo.nemo.data.service

import org.junwoo.nemo.data.model.dto.UserDto
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {
    @GET("user/get/{id}")
    suspend fun getUserId(@Path("id") id: Long): UserDto
}