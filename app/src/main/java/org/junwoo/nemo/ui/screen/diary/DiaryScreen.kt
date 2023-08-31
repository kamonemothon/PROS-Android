package org.junwoo.nemo.ui.screen.diary

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.junwoo.nemo.R
import org.junwoo.nemo.domain.model.Diary
import org.junwoo.nemo.ui.theme.NEPL_BLACK
import org.junwoo.nemo.ui.theme.NEPL_GRAY_30
import org.junwoo.nemo.ui.theme.NEPL_GRAY_40
import org.junwoo.nemo.ui.theme.NEPL_GRAY_60
import org.junwoo.nemo.ui.theme.pretendardFamily
import org.junwoo.nemo.ui.view.DiaryDatePickerDialog

@Composable
fun DiaryScreen(
    viewModel: DiaryViewModel = hiltViewModel(),
    onDiaryClicked: () -> Unit
) {
    var dialogVisible by remember { mutableStateOf(false) }
    val diary by viewModel.diaryList.collectAsStateWithLifecycle()
    var currentDate by remember {
        mutableStateOf(Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()))
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF0F1F4))
            .padding(20.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
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
            Image(painter = painterResource(id = R.drawable.ic_setting), contentDescription = null)
        }
        Spacer(modifier = Modifier.height(25.dp))
        OutlinedButton(
            onClick = { dialogVisible = true },
            shape = RoundedCornerShape(12.dp),
            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 7.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Transparent,
                contentColor = NEPL_GRAY_60
            )
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "${currentDate.monthNumber}월 ${currentDate.dayOfMonth}일"
                )
                Spacer(modifier = Modifier.width(4.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_calendar),
                    contentDescription = null
                )
            }
        }
        Spacer(modifier = Modifier.height(25.dp))
        LazyRow(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(diary) {
                DiaryCardView(
                    modifier = Modifier.aspectRatio(3 / 5f),
                    it
                )
            }
        }
    }
    if (dialogVisible) {
        Dialog(onDismissRequest = { dialogVisible = false }) {
            DiaryDatePickerDialog(
                onDialogDismissed = { dialogVisible = false },
                year = currentDate.year,
                month = currentDate.monthNumber,
                day = currentDate.dayOfMonth
            ) { year, month, day ->
                dialogVisible = false
                currentDate = LocalDateTime(year, month, day, 0, 0, 0)
            }
        }
    }
}

@Composable
fun DiaryCardView(
    modifier: Modifier = Modifier,
    diary: Diary
) {
    Card(
        modifier = modifier
            .fillMaxSize(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
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
            Spacer(modifier = Modifier.height(16.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "${diary.place.city} ${diary.place.district} ${diary.place.neighborhood} ${diary.place.street}",
                    fontFamily = pretendardFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    color = NEPL_GRAY_40
                )

            }
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.TopStart
            ) {
                AsyncImage(
                    modifier = Modifier.fillMaxWidth().aspectRatio(1f),
                    model = diary.thumbnail,
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth
                )
                Text(
                    modifier = Modifier
                        .background(color = NEPL_BLACK, shape = RoundedCornerShape(size = 15.5.dp))
                        .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp),
                    text = diary.modifiedDate,
                    color = Color.White,
                    fontFamily = pretendardFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = diary.content,
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 19.2.sp,
                    fontFamily = pretendardFamily,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF353535),
                ),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}