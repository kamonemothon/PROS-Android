package org.junwoo.nemo.data.mapper

import org.junwoo.nemo.data.model.dto.PlaceDto
import org.junwoo.nemo.domain.model.LocationType
import org.junwoo.nemo.domain.model.Place

fun PlaceDto.toPlace(): Place = Place(
    buildingNumber,
    city,
    district,
    thumbnail,
    id,
    neighborhood,
    placeName,
    phone,
    street = street,
    type = LocationType.valueOf(type),
    latitude = latitude.toDouble(),
    longitude = longitude.toDouble()
)