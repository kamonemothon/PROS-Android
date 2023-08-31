package org.junwoo.nemo.data.service

import org.junwoo.nemo.data.model.dto.PlanDto
import org.junwoo.nemo.data.model.request.PlanCreateRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PlanService {
    @POST("/plan/add")
    suspend fun createPlan(@Body request: PlanCreateRequest)

    @GET("plan/getAll")
    suspend fun getAllPlans(): List<PlanDto>

    @GET("plan/view/{planId}")
    suspend fun getUserPlans(@Path("planId") userId: Long = 1): PlanDto

}
