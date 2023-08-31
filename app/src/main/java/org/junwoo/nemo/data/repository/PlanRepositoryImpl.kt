package org.junwoo.nemo.data.repository

import org.junwoo.nemo.data.model.request.PlanCreateRequest
import org.junwoo.nemo.data.service.PlanService
import org.junwoo.nemo.data.model.dto.UserDto
import org.junwoo.nemo.domain.model.Plan
import org.junwoo.nemo.domain.repository.PlanRepository
import org.junwoo.nemo.domain.model.User
import java.time.LocalDateTime
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlanRepositoryImpl @Inject constructor(
    private val planService: PlanService
) : PlanRepository {
    override suspend fun createPlan(
        departureDateTime: LocalDateTime,
        public: Boolean,
        title: String,
        user: User
    ): Boolean {
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
            return true
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }
    }

    override suspend fun getAllPlans(): List<Plan> = dummyPlan

    override suspend fun getUserPlans(userId: Long): Plan = dummyPlan[0]
}

val dummyPlan = listOf<Plan>(
    Plan(
        departureDateTime = "202309221010",
        thumbnail = "https://firebasestorage.googleapis.com/v0/b/imgimg-6a797.appspot.com/o/planThumbnail%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-08-31%20204042.png?alt=media&token=07ee504f-49ae-4374-8b72-5a6d47a34c6c",
        id = 2,
        public = false,
        title = "강화 유적지 탐방",
        user = dummyUser
    ),
    Plan(
        departureDateTime = "202309221010",
        thumbnail = "https://firebasestorage.googleapis.com/v0/b/imgimg-6a797.appspot.com/o/planThumbnail%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-08-31%20204049.png?alt=media&token=d94a7807-50a3-447f-a68c-9280f3cba58a",
        id = 3,
        public = false,
        title = "다함께 공원 고",
        user = dummyUser
    ),
    Plan(
        departureDateTime = "202309221010",
        thumbnail = "https://firebasestorage.googleapis.com/v0/b/imgimg-6a797.appspot.com/o/planThumbnail%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-08-31%20204056.png?alt=media&token=01f1e83b-7ef5-46f7-99d8-ccef5b050ef6",
        id = 4,
        public = false,
        title = "흥이 절로 나는 드라이브",
        user = dummyUser
    ),
    Plan(
        departureDateTime = "202309221010",
        thumbnail = "https://firebasestorage.googleapis.com/v0/b/imgimg-6a797.appspot.com/o/planThumbnail%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-08-31%20204106.png?alt=media&token=6a72d41e-5652-46b8-8d9c-be109eea630d",
        id = 5,
        public = false,
        title = "나의 작년이 담긴 갬성 코스",
        user = dummyUser
    ),
    Plan(
        departureDateTime = "202309221010",
        thumbnail = "https://firebasestorage.googleapis.com/v0/b/imgimg-6a797.appspot.com/o/planThumbnail%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-08-31%20204121.png?alt=media&token=e47a5f90-5368-4c3e-a4cc-519609b4d314",
        id = 6,
        public = false,
        title = "바다부터 내륙까지 인천 크로스",
        user = dummyUser
    ),
    Plan(
        departureDateTime = "202309221010",
        thumbnail = "https://firebasestorage.googleapis.com/v0/b/imgimg-6a797.appspot.com/o/planThumbnail%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-08-31%20204131.png?alt=media&token=7d363bb9-14d6-4fcc-b606-7fef14cb18a8",
        id = 7,
        public = false,
        title = "우도 탐방",
        user = dummyUser
    ),
    Plan(
        departureDateTime = "202309221010",
        thumbnail = "https://firebasestorage.googleapis.com/v0/b/imgimg-6a797.appspot.com/o/planThumbnail%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-08-31%20204138.png?alt=media&token=2cc31ad3-9f6d-4de6-8748-95c5794a85ab",
        id = 8,
        public = false,
        title = "서울 카페 투어",
        user = dummyUser
    ),
    Plan(
        departureDateTime = "202309221010",
        thumbnail = "https://firebasestorage.googleapis.com/v0/b/imgimg-6a797.appspot.com/o/planThumbnail%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-08-31%20204151.png?alt=media&token=df2637be-7a7b-47bb-8860-7ff2db58506d",
        id = 9,
        public = false,
        title = "제주 바다 둘레길을 점령해보자아~",
        user = dummyUser
    ),
    Plan(
        departureDateTime = "202309221010",
        thumbnail = "https://firebasestorage.googleapis.com/v0/b/imgimg-6a797.appspot.com/o/planThumbnail%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-08-31%20204157.png?alt=media&token=6b3b25ce-365e-4f14-837f-6d6760bb2605",
        id = 10,
        public = false,
        title = "서귀포 감귤 여행",
        user = dummyUser
    ),
    Plan(
        departureDateTime = "202309221010",
        thumbnail = "https://firebasestorage.googleapis.com/v0/b/imgimg-6a797.appspot.com/o/planThumbnail%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-08-31%20204203.png?alt=media&token=a7f84244-6097-4431-9c36-b503ca7d7dc4",
        id = 11,
        public = false,
        title = "전주를 가로지르는 직진 코스",
        user = dummyUser
    ),
    Plan(
        departureDateTime = "202309221010",
        thumbnail = "https://firebasestorage.googleapis.com/v0/b/imgimg-6a797.appspot.com/o/planThumbnail%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-08-31%20204208.png?alt=media&token=ee18160a-01c6-4a5b-8c0c-e76b7f0e088e",
        id = 12,
        public = false,
        title = "푸른 숲을 정복하는 나만의 드라이브 코스",
        user = dummyUser
    ),

)