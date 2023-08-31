package org.junwoo.nemo.data.service

import org.junwoo.nemo.data.model.dto.PlaceDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PlaceService {
    @GET("place/get/{id}")
    suspend fun getPlacesById(@Path("id") placeId: Long): PlaceDto

    @GET("place/search")
    suspend fun searchPlace(
        @Query("city") city: String,
        @Query("district") district: String,
        @Query("neighborhood") neighborhood: String,
        @Query("street") street: String,
        @Query("buildingNumber") buildingNumber: String
    ): List<PlaceDto>
}