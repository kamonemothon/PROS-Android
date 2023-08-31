@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package org.junwoo.nemo.ui.screen.createplan

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.junwoo.nemo.R
import org.junwoo.nemo.domain.model.LocationType
import org.junwoo.nemo.domain.model.Place
import org.junwoo.nemo.ui.theme.NEPL_GRAY_30
import org.junwoo.nemo.ui.theme.NEPL_GRAY_40
import org.junwoo.nemo.ui.theme.NEPL_GRAY_60
import org.junwoo.nemo.ui.theme.NEPL_GREEN
import org.junwoo.nemo.ui.theme.pretendardFamily
import org.junwoo.nemo.ui.view.KakaoMapView
import org.junwoo.nemo.ui.view.PlaceDetailBottomDialog

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CreatePlanScreen(
    onDetailClicked: () -> Unit
) {
    var text by remember { mutableStateOf("") }
    BottomSheetScaffold(
        sheetShape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
        sheetElevation = 20.dp,
        sheetPeekHeight = 300.dp,
        sheetContent = {
            PlaceDetailBottomDialog(
                modifier = Modifier
                    .heightIn(min = 300.dp, max = 300.dp),
                place = Place(
                    buildingNumber = "11",
                    city = "제주",
                    district = "제주시",
                    thumbnail = "https://firebasestorage.googleapis.com/v0/b/imgimg-6a797.appspot.com/o/placeData%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-08-31%20201754.png?alt=media&token=62073576-9781-49a3-aef4-bf7a53df8d81",
                    id = 1,
                    neighborhood = "삼도이동",
                    placeName = "우진해장국",
                    phone = "064-757-3393",
                    street = "서사로",
                    LocationType.CAFE,
                    latitude = 126.52000128027187,
                    longitude = 33.51151689656457
                ), diaryList = listOf()
            )
        },
        content = {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopEnd,
            ) {
                KakaoMapView(
                    modifier = Modifier.fillMaxSize(),
                    initialLatitude = 126.52000128027187,
                    initialLongitude = 33.51151689656457
                )
                Column(
                    modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    OutlinedTextField(
                        shape = RoundedCornerShape(15.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color.White,
                            unfocusedBorderColor = NEPL_GRAY_30,
                            focusedBorderColor = NEPL_GRAY_60
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        value = text, onValueChange = { text = it },
                        trailingIcon = {
                            Image(
                                painter = painterResource(id = R.drawable.ic_search),
                                contentDescription = null
                            )
                        },
                        placeholder = {
                            Text(
                                text = "장소, 지역 명으로 검색",
                                fontFamily = pretendardFamily,
                                fontWeight = FontWeight.Medium,
                                color = NEPL_GRAY_40,
                                fontSize = 14.sp
                            )
                        }
                    )
                    Box(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(top = 16.dp, end = 20.dp)
                            .clickable {
                                onDetailClicked()
                            },
                        contentAlignment = Alignment.TopEnd
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_cart_fab),
                            contentDescription = null
                        )
                        Text(
                            modifier = Modifier
                                .size(16.dp)
                                .background(
                                    color = NEPL_GREEN
                                ),
                            text = "1",
                            textAlign = TextAlign.Center,
                            fontFamily = pretendardFamily,
                            fontWeight = FontWeight.Normal,
                            color = NEPL_GRAY_60
                        )
                    }
                }
            }
        }
    )
}