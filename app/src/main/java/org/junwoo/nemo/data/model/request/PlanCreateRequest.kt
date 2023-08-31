package org.junwoo.nemo.data.model.request

import org.junwoo.nemo.data.model.dto.UserDto
import java.time.LocalDateTime

data class PlanCreateRequest(
    val departureDateTime: LocalDateTime,
    val public: Boolean,
    val title: String,
    val user: UserDto
)