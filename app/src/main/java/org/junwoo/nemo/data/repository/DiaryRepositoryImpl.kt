package org.junwoo.nemo.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.junwoo.nemo.data.service.DiaryService
import org.junwoo.nemo.data.mapper.toDiary
import org.junwoo.nemo.domain.model.Diary
import org.junwoo.nemo.domain.model.Place
import org.junwoo.nemo.domain.repository.DiaryRepository
import java.time.LocalDateTime
import javax.inject.Inject

class DiaryRepositoryImpl @Inject constructor(
    private val service: DiaryService
) : DiaryRepository {
    override fun getDiaries(): Flow<List<Diary>> = flow {
        val list = service.getDiariesByUserId()
        emit(list.map { it.toDiary() })
    }

    override fun getDiariesByDateTime(dateTime: LocalDateTime): Flow<List<Diary>> = flow{
       emit(service.getDiariesByUserIdWithDate(date = dateTime.toString()).map { it.toDiary() })
    }

    override fun getDiariesByPlaceId(placeId: Long): Flow<List<Diary>> = flow {
        emit(service.getDiariesByUserWithPlaceId(placeId = placeId).map { it.toDiary() })
    }
}