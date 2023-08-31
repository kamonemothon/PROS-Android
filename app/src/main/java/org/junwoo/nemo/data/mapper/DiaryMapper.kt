package org.junwoo.nemo.data.mapper

import org.junwoo.nemo.data.model.dto.DiaryDto
import org.junwoo.nemo.domain.model.Diary

fun DiaryDto.toDiary(): Diary = Diary(
    content,
    createdDate,
    url,
    id,
    modifiedDate,
    place = place.toPlace(),
    user = user.toUser()

)