package org.junwoo.nemo.domain.repository

import kotlinx.coroutines.flow.Flow
import org.junwoo.nemo.domain.model.Plan
import org.junwoo.nemo.domain.model.User
import java.time.LocalDateTime

interface PlanRepository {
    fun createPlan(
        departureDateTime: LocalDateTime,
        public: Boolean,
        title: String,
        user: User
    ): Flow<Boolean>

    fun getAllPlans(): Flow<List<Plan>>

    fun getUserPlans(userId: Long): Flow<List<Plan>>
}