package org.junwoo.nemo.data.repository

import org.junwoo.nemo.data.service.DiaryService
import org.junwoo.nemo.domain.model.Diary
import org.junwoo.nemo.domain.repository.DiaryRepository
import java.time.LocalDateTime
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DiaryRepositoryImpl @Inject constructor(
    private val service: DiaryService
) : DiaryRepository {
    override suspend fun getDiaries(): List<Diary> = dummyDiary

    override suspend fun getDiariesByDateTime(dateTime: LocalDateTime): List<Diary> = dummyDiary

    override suspend fun getDiariesByPlaceId(placeId: Long): List<Diary> = dummyDiary
}

val dummyDiary = listOf<Diary>(
    Diary(
        content = "오후에 햇빛을 받으면서 맛잇는 에스프레소 한잔..\n 커피는 코로 마시는거다. 레트로와 섞여서 한\n 층더 갬성과 풍미가 더해지는것 같다.. :D",
        createdDate = "2023.08.31 15:11",
        thumbnail = "https://firebasestorage.googleapis.com/v0/b/imgimg-6a797.appspot.com/o/diarydata%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-08-31%20233746.png?alt=media&token=f542d07f-15e8-43fb-8dea-0aafbdd9fede",
        id = 1,
        modifiedDate = "2023.08.31 15:11",
        place = dummyPlaces[11],
        user = dummyUser
    ),
    Diary(
        content = "오늘은 제주도에서 우진 해장국을 먹었다.\n 시계가 오후 13:10을 가리킬 때, 입안 가득 맛있는 \n국물이 입맛을 돋구었다. 특히 고사리 해장국은 그 풍미가 일품이었는데, 맛있어서 기다림도 아깝지 않았다.",
        createdDate = "2023.08.31 15:11",
        thumbnail = "ttps://firebasestorage.googleapis.com/v0/b/imgimg-6a797.appspot.com/o/placeData%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-08-31%20201852.png?alt=media&token=1225c783-9f32-4490-8cab-b170adb15019",
        id = 2,
        modifiedDate = "2023.08.31 15:11",
        place = dummyPlaces[0],
        user = dummyUser
    ),
    Diary(
        content = "오늘은 함덕해수욕장에 왔다. 시계가 10:47을 가리킬 때, 해변은 이미 사람들로 붐비고 있었다. 맑은 바다와 시원한 바람, 그리고 활기찬 모습이 마음을 즐겁게 만들어 주었다.",
        createdDate = "2023.08.31 10:47",
        thumbnail = "https://firebasestorage.googleapis.com/v0/b/imgimg-6a797.appspot.com/o/placeData%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-08-31%20201953.png?alt=media&token=81355679-64b1-42a3-b8e9-63680ad79d30",
        id = 3,
        modifiedDate = "2023.08.31 15:11",
        place = dummyPlaces[1],
        user = dummyUser
    ),
    Diary(
        content = "제주도 이룸 미술관에 도착해 미술품들을 감상했다. 소나무를 주제로 그려놓은 우키요에 스타일의 그림들을 보면서 잠시 감상에 빠졌다. 사람들이 많았지만 시선을 끌어당기는 색채의 대비. 마음의 안정을 준다.",
        createdDate = "2023.08.31 10:47",
        thumbnail = "https://firebasestorage.googleapis.com/v0/b/imgimg-6a797.appspot.com/o/placeData%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-08-31%20201953.png?alt=media&token=81355679-64b1-42a3-b8e9-63680ad79d30",
        id = 4,
        modifiedDate = "2023.08.31 15:11",
        place = dummyPlaces[2],
        user = dummyUser
    ),
    Diary(
        content = "랜디스 도넛에 도착하여 옥상 테라스에서 보는 바다 풍경을 담았다. 파란 하늘과 바다, 그리고 초록 빛의 잔듸까지 모든 것이 조화로웠다. 도넛의 구멍이 하나의 액자와 같이 느껴졌다!",
        createdDate = "2023.08.31 10:47",
        thumbnail = "https://firebasestorage.googleapis.com/v0/b/imgimg-6a797.appspot.com/o/diarydata%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-08-31%20235426.png?alt=media&token=5dd0a5c1-2a62-4435-a7f4-369aad5d1228",
        id = 5,
        modifiedDate = "2023.08.31 15:11",
        place = dummyPlaces[3],
        user = dummyUser
    ),
    Diary(
        content = "안녕하신지요! 육지에서 온 친구와 만나 하고수동점에서 특별한 하루를 보냈습니다. 이른 아침 9:42에 우도에 도착해 아름다운 풍경과 함께 힐링하는 시간을 가졌어요. 카페에서 맛있는 크로플을 먹으며 소중한 추억을 만들었습니다",
        createdDate = "2023.08.31 10:47",
        thumbnail = "https://firebasestorage.googleapis.com/v0/b/imgimg-6a797.appspot.com/o/diarydata%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-08-31%20203620.png?alt=media&token=1a768e86-5388-4d5b-b5e5-de8d517cd4d0",
        id = 6,
        modifiedDate = "2023.08.31 15:11",
        place = dummyPlaces[4],
        user = dummyUser
    ),
    )
