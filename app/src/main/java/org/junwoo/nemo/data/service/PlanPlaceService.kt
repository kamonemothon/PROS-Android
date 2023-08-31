package org.junwoo.nemo.data.service

import org.junwoo.nemo.data.model.dto.PlanDto
import org.junwoo.nemo.data.model.request.PlanPlaceAddRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PlanPlaceService {
    @POST("/planplaces/add")
    suspend fun addPlanPlaces(@Body req: PlanPlaceAddRequest)

    @GET("/planplaces/search/by-plan/{planId}")
    suspend fun getPlanByPlanId(@Path("planId") planId: Long = 1): PlanDto
}