package org.junwoo.nemo.domain.repository

import org.junwoo.nemo.domain.model.Plan
import org.junwoo.nemo.domain.model.User
import java.time.LocalDateTime

interface PlanRepository {
    suspend fun createPlan(
        departureDateTime: LocalDateTime,
        public: Boolean,
        title: String,
        user: User
    ): Boolean

    suspend fun getAllPlans(): List<Plan>

    suspend fun getUserPlans(userId: Long): Plan
}