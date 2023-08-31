package org.junwoo.nemo.domain.repository

import org.junwoo.nemo.domain.model.Place

interface PlaceRepository {
    suspend fun getPlaceById(placeId: Long): Place

    suspend fun searchPlace(
        city: String = "",
        district: String = "",
        neighborhood: String = "",
        street: String = "",
        buildingNumber: String = ""
    ): List<Place>
}