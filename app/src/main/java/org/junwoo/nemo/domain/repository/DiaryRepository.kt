package org.junwoo.nemo.domain.repository

import kotlinx.coroutines.flow.Flow
import org.junwoo.nemo.domain.model.Diary
import java.time.LocalDateTime

interface DiaryRepository {
    fun getDiaries(): Flow<List<Diary>>

    fun getDiariesByDateTime(dateTime: LocalDateTime): Flow<List<Diary>>

    fun getDiariesByPlaceId(placeId: Long): Flow<List<Diary>>
}