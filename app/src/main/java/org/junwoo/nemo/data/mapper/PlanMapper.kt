package org.junwoo.nemo.data.mapper

import org.junwoo.nemo.data.model.dto.PlanDto
import org.junwoo.nemo.domain.model.Plan
import java.time.LocalDateTime

fun PlanDto.toPlan(): Plan = Plan(
    departureDateTime,
    thumbnail,
    id,
    public,
    title = title,
    user = user.toUser()
)