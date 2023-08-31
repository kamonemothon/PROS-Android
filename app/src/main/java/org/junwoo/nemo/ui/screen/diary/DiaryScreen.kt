package org.junwoo.nemo.ui.screen.diary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import org.junwoo.nemo.domain.model.Diary
import org.junwoo.nemo.ui.theme.NEPL_BLACK
import org.junwoo.nemo.ui.theme.NEPL_GRAY_30
import org.junwoo.nemo.ui.theme.pretendardFamily

@Composable
fun DiaryScreen(
    viewModel: DiaryViewModel = hiltViewModel(),
    onDiaryClicked: () -> Unit
) {
    val diary by viewModel.diaryList.collectAsState()
    Column(modifier = Modifier.fillMaxWidth()) {
        Row {
            Text(
                text = "AI 다이어리",
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 32.sp,
                    fontFamily = pretendardFamily
                ),
                fontWeight = FontWeight(700),
                color = NEPL_BLACK,
                letterSpacing = 1.sp,
            )
            Spacer(modifier = Modifier.weight(1f))
        }
        Spacer(modifier = Modifier.height(25.dp))
        LazyRow(modifier = Modifier.weight(1f)) {
            items(diary) {
                DiaryCardView(
                    it
                )
            }
        }
    }
}

@Composable
fun DiaryCardView(diary: Diary) {
    Surface(
        modifier = Modifier
            .aspectRatio(3 / 5f),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = diary.place.placeName,
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 18.sp,
                    fontFamily = pretendardFamily,
                    fontWeight = FontWeight(600),
                    color = NEPL_BLACK,
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "${diary.place.type}",
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 19.2.sp,
                    fontFamily = pretendardFamily,
                    fontWeight = FontWeight(500),
                    color = NEPL_GRAY_30,
                )
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.TopStart
            ) {
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = "", // 유저 썸네일
                    contentDescription = null
                )
                Text(
                    modifier = Modifier
                        .width(79.dp)
                        .height(27.dp)
                        .background(color = NEPL_BLACK, shape = RoundedCornerShape(size = 15.5.dp))
                        .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp),
                    text = diary.modifiedDate
                )
            }
            Text(
                text = diary.content,
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 19.2.sp,
                    fontFamily = pretendardFamily,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF353535),
                )
            )
        }
    }
}