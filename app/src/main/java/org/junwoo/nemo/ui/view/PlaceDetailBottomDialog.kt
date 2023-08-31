package org.junwoo.nemo.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import org.junwoo.nemo.domain.model.Diary
import org.junwoo.nemo.domain.model.Place
import org.junwoo.nemo.ui.theme.NEPL_GRAY_10
import org.junwoo.nemo.ui.theme.NEPL_GRAY_60
import org.junwoo.nemo.ui.theme.NEPL_GREEN
import org.junwoo.nemo.ui.theme.pretendardFamily

@Composable
fun PlaceDetailBottomDialog(
    modifier: Modifier = Modifier,
    place: Place,
    diaryList: List<Diary>
) {
    Surface(modifier = modifier.fillMaxWidth()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.height(30.dp))
            Row {
                Spacer(modifier = Modifier.width(20.dp))
                AsyncImage(
                    place.thumbnail,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(15.dp)),
                    contentDescription = "image description",
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(20.dp))
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = place.placeName,
                            style = TextStyle(
                                fontSize = 16.sp,
                                lineHeight = 25.6.sp,
                                fontFamily = pretendardFamily,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF494949),
                            )
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = place.type.name,
                            style = TextStyle(
                                fontSize = 12.sp,
                                lineHeight = 19.2.sp,
                                fontFamily = pretendardFamily,
                                fontWeight = FontWeight(500),
                                color = Color(0xFFB3B3B3),
                            )
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            modifier = Modifier.size(12.dp),
                            imageVector = Icons.Default.Place,
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "${place.city} ${place.district} ${place.neighborhood} ${place.street} ${place.buildingNumber}",
                            style = TextStyle(
                                fontSize = 12.sp,
                                lineHeight = 19.2.sp,
                                fontFamily = pretendardFamily,
                                fontWeight = FontWeight(500),
                                color = Color(0xFF727171),
                            )
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            modifier = Modifier.size(12.dp),
                            imageVector = Icons.Default.Phone,
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = place.buildingNumber,
                            style = TextStyle(
                                fontSize = 12.sp,
                                lineHeight = 19.2.sp,
                                fontFamily = pretendardFamily,
                                fontWeight = FontWeight(500),
                                color = Color(0xFF727171),
                            )
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .weight(1f),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = NEPL_GRAY_10,
                        contentColor = NEPL_GRAY_60
                    )
                ) {
                    Text(text = "공유하기")
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        modifier = Modifier.size(14.dp),
                        imageVector = Icons.Default.Share,
                        contentDescription = null
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .weight(1f),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = NEPL_GREEN,
                        contentColor = NEPL_GRAY_60
                    )
                ) {
                    Text(text = "경유지 등록")
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        modifier = Modifier.size(14.dp),
                        imageVector = Icons.Default.Add,
                        contentDescription = null
                    )
                }
            }
            Spacer(modifier = Modifier.height(15.dp))
            MyDiaryItemComponent(list = diaryList)
        }
    }
}

@Composable
fun MyDiaryItemComponent(list: List<Diary>) {
    Column {
        Text(
            modifier = Modifier.padding(start = 25.dp),
            text = "마이 다이어리 ${list.count()}",
            fontFamily = pretendardFamily,
            color = NEPL_GRAY_60,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
        )
        LazyRow {
            items(list) {
                AsyncImage(
                    modifier = Modifier.aspectRatio(1f),
                    model = it.thumbnail,
                    contentDescription = null
                )
            }
        }
    }
}