package org.junwoo.nemo.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.junwoo.nemo.data.model.request.PlanCreateRequest
import org.junwoo.nemo.data.service.PlanService
import org.junwoo.nemo.data.model.dto.UserDto
import org.junwoo.nemo.data.mapper.toPlan
import org.junwoo.nemo.domain.model.Plan
import org.junwoo.nemo.domain.repository.PlanRepository
import org.junwoo.nemo.domain.model.User
import java.time.LocalDateTime
import javax.inject.Inject

class PlanRepositoryImpl @Inject constructor(
    private val planService: PlanService
) : PlanRepository {
    override fun createPlan(
        departureDateTime: LocalDateTime,
        public: Boolean,
        title: String,
        user: User
    ): Flow<Boolean> = flow {
        try {
            planService.createPlan(
                PlanCreateRequest(
                    departureDateTime,
                    public,
                    title,
                    UserDto(
                        "", "", "", 1, "", "", "", ""
                    )
                )
            )
            emit(true)
        } catch (e: Exception) {
            e.printStackTrace()
            emit(false)
        }
    }

    override fun getAllPlans(): Flow<List<Plan>> = flow {
        val list = planService.getAllPlans()
        emit(list.map { it.toPlan() })
    }

    override fun getUserPlans(userId: Long): Flow<List<Plan>> = flow {
        val list = planService.getUserPlans()
        emit(list.map { it.toPlan() })
    }
}