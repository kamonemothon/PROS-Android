package org.junwoo.nemo.data.service

import org.junwoo.nemo.data.model.dto.DiaryDto
import retrofit2.http.GET
import retrofit2.http.Path

interface DiaryService {
    @GET("/diaries")
    suspend fun getDiariesByUserId(): List<DiaryDto>

    @GET("/diaries/user/{userId}/date/{date}")
    suspend fun getDiariesByUserIdWithDate(
        @Path("userId") userId: Long = 1,
        @Path("date") date: String
    ): List<DiaryDto>

    @GET("/diaries/user/{userId}/place/{placeId}")
    suspend fun getDiariesByUserWithPlaceId(
        @Path("userId") userId: Long = 1,
        @Path("placeId") placeId: Long
    ): List<DiaryDto>
}