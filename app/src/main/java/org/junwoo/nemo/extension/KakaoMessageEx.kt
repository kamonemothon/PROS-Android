package org.junwoo.nemo.extension

import android.content.ActivityNotFoundException
import android.content.Context
import android.util.Log
import com.kakao.sdk.common.util.KakaoCustomTabsClient
import com.kakao.sdk.share.ShareClient
import com.kakao.sdk.share.WebSharerClient
import com.kakao.sdk.template.model.Button
import com.kakao.sdk.template.model.Content
import com.kakao.sdk.template.model.FeedTemplate
import com.kakao.sdk.template.model.Link
import org.junwoo.nemo.domain.model.Plan

fun Context.sendDefaultFeedMessage(
    plan: Plan,
    placeCount: Int
) {
    val feed = FeedTemplate(
        content = Content(
            title = plan.title,
            description = "등록 경유지 ${placeCount}개  ㅣ  ${plan.departureDateTime}",
            imageUrl = "https://firebasestorage.googleapis.com/v0/b/imgimg-6a797.appspot.com/o/shareplan.png?alt=media&token=ca2ec693-1a74-4934-9daf-bb63d7bae90a",
            link = Link(
                webUrl = "https://developers.kakao.com",
                mobileWebUrl = "https://developers.kakao.com"
            )
        ),
        buttons = listOf(
            Button(
                "자세히 보기",
                Link("https://developers.kakao.com")
            )
        )
    )
    if (ShareClient.instance.isKakaoTalkSharingAvailable(this)) {
        ShareClient.instance.shareDefault(this, feed) { sharingResult, error ->
            if (error != null) {
                Log.e("MyTag", "카카오톡 공유 실패", error)
            } else if (sharingResult != null) {
                Log.d("MyTag", "카카오톡 공유 성공 ${sharingResult.intent}")
                startActivity(sharingResult.intent)

                // 카카오톡 공유에 성공했지만 아래 경고 메시지가 존재할 경우 일부 컨텐츠가 정상 동작하지 않을 수 있습니다.
                Log.w("MyTag", "Warning Msg: ${sharingResult.warningMsg}")
                Log.w("MyTag", "Argument Msg: ${sharingResult.argumentMsg}")
            }
        }
    } else {
        // 카카오톡 미설치: 웹 공유 사용 권장
        // 웹 공유 예시 코드
        val sharerUrl = WebSharerClient.instance.makeDefaultUrl(feed)

        // CustomTabs으로 웹 브라우저 열기

        // 1. CustomTabsServiceConnection 지원 브라우저 열기
        // ex) Chrome, 삼성 인터넷, FireFox, 웨일 등
        try {
            KakaoCustomTabsClient.openWithDefault(this, sharerUrl)
        } catch (e: UnsupportedOperationException) {
            // CustomTabsServiceConnection 지원 브라우저가 없을 때 예외처리
        }

        // 2. CustomTabsServiceConnection 미지원 브라우저 열기
        // ex) 다음, 네이버 등
        try {
            KakaoCustomTabsClient.open(this, sharerUrl)
        } catch (e: ActivityNotFoundException) {
            // 디바이스에 설치된 인터넷 브라우저가 없을 때 예외처리
        }
    }
}

//{
//    "departureDatetime": "202309221010",
//    "fileURL": "https://firebasestorage.googleapis.com/v0/b/imgimg-6a797.appspot.com/o/planThumbnail%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-08-31%20204034.png?alt=media&token=559dd184-1431-4753-b66a-4557689d611c",
//    "id": 1,
//    "public": false,
//    "title": "인천 당일 부수기",
//    "user": {
//    "address": "서울 동대문구 망우로14가길 90",
//    "createdDate": "2023.08.31 15:11",
//    "email": "wlskb@naver.com",
//    "id": 1,
//    "modifiedDate": "2023.08.31 15:11",
//    "name": "유지나",
//    "nickname": "지르나르",
//    "password": "jinajjang1128"
//}
//}

//{
//    "id": 1,
//    "city": "제주",
//    "district": "제주시",
//    "fileURL": "https://firebasestorage.googleapis.com/v0/b/imgimg-6a797.appspot.com/o/placeData%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-08-31%20201754.png?alt=media&token=62073576-9781-49a3-aef4-bf7a53df8d81",
//    "neighborhood": "삼도이동",
//    "place_name": "우진해장국",
//    "street": "서사로",
//    "buildingNumber": "11",
//    "phone":"064-757-3393"
//    "type": "CAFE",
//    "x": "126.52000128027187",
//    "y": "33.51151689656457"
//
//}