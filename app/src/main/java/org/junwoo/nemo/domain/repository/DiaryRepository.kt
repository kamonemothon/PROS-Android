package org.junwoo.nemo.domain.repository

import org.junwoo.nemo.domain.model.Diary
import java.time.LocalDateTime

interface DiaryRepository {
    suspend fun getDiaries(): List<Diary>

    suspend fun getDiariesByDateTime(dateTime: LocalDateTime): List<Diary>

    suspend fun getDiariesByPlaceId(placeId: Long): List<Diary>
}