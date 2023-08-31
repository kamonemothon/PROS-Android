package org.junwoo.nemo.domain.repository

import kotlinx.coroutines.flow.Flow
import org.junwoo.nemo.domain.model.Place

interface PlaceRepository {
    fun getPlaceById(placeId: Long): Flow<Place>

    fun searchPlace(
        city: String = "",
        district: String = "",
        neighborhood: String = "",
        street: String = "",
        buildingNumber: String = ""
    ): Flow<List<Place>>
}