package org.junwoo.nemo.data.mapper

import org.junwoo.nemo.data.model.dto.PlanPlaceDto
import org.junwoo.nemo.domain.model.PlaceOrderType
import org.junwoo.nemo.domain.model.PlanPlace

fun PlanPlaceDto.toPlanPlace(): PlanPlace = PlanPlace(
    id = id,
    place = place.toPlace(),
    placeOrder = PlaceOrderType.valueOf(placeOrder).ordinal,
    plan = plan.toPlan()
)