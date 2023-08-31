package org.junwoo.nemo.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
import org.junwoo.nemo.ui.theme.pretendardFamily

@Composable
fun placeDetailBottomDialog(place: Place, diaryList: List<Diary>) {
    Surface {
        Column {
            Row {
                AsyncImage(
                    "",
                    contentDescription = "image description",
                    contentScale = ContentScale.FillBounds
                )
                Column {
                    Row {
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
                    Row {
                        Icon(Icons.Default.Place, contentDescription = null)
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
                    Row {
                        Icon(Icons.Default.Phone, contentDescription = null)
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
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)) {
                        Button(onClick = { /*TODO*/ },
                            modifier = Modifier
                                .weight(1f)
                                .background(
                                    color = NEPL_GRAY_10,
                                    shape = RoundedCornerShape(size = 12.dp)
                                )) {
                            Text(text = "공유하기")
                            Icon(Icons.Default.Share, contentDescription = null)
                        }
                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .weight(1f)
                                .background(
                                    color = Color(0xFFBFFF56),
                                    shape = RoundedCornerShape(size = 12.dp)
                                )
                        ) {
                            Text(text = "경유지 등록")
                            Icon(Icons.Default.Add, contentDescription = null)
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    MyDiaryItemComponent(list = diaryList)
                }
            }
        }
    }
}

@Composable
fun MyDiaryItemComponent(list: List<Diary>) {
    Column {
        Text(text = "마이 다이어리 ${list.count()}")
        LazyRow {
            items(list) {
                AsyncImage(
                    modifier = Modifier.aspectRatio(1f),
                    model = it,
                    contentDescription = null
                )
            }
        }
    }
}