package org.junwoo.nemo.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.junwoo.nemo.data.service.PlaceService
import org.junwoo.nemo.data.mapper.toPlace
import org.junwoo.nemo.domain.model.Place
import org.junwoo.nemo.domain.repository.PlaceRepository
import javax.inject.Inject

class PlaceRepositoryImpl @Inject constructor(
    private val placeService: PlaceService
): PlaceRepository {
    override fun getPlaceById(userId: Long): Flow<Place> = flow {
        val place = placeService.getPlacesById(userId)
        emit(place.toPlace())
    }

    override fun searchPlace(
        city: String,
        district: String,
        neighborhood: String,
        street: String,
        buildingNumber: String
    ): Flow<List<Place>> = flow {
        val placeList = placeService.searchPlace(city, district, neighborhood, street, buildingNumber)
        emit(placeList.map { it.toPlace() })
    }
}