package org.junwoo.nemo.data.mapper

import org.junwoo.nemo.data.model.dto.UserDto
import org.junwoo.nemo.domain.model.User

fun User.toUserDto(): UserDto = UserDto(
    address = address,
    createdDate = createdDate,
    email = email,
    id = id,
    modifiedDate = modifiedDate,
    name = name,
    nickname = nickname,
    password = password
)

fun UserDto.toUser(): User = User(
    address = address,
    createdDate = createdDate,
    email = email,
    id = id,
    modifiedDate = modifiedDate,
    name = name,
    nickname = nickname,
    password = password
)