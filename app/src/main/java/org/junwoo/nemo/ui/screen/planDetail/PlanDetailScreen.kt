package org.junwoo.nemo.ui.screen.planDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.junwoo.nemo.R
import org.junwoo.nemo.domain.model.Plan
import org.junwoo.nemo.domain.model.User
import org.junwoo.nemo.extension.sendDefaultFeedMessage
import org.junwoo.nemo.ui.theme.NEPL_BLACK
import org.junwoo.nemo.ui.theme.NEPL_GRAY_10
import org.junwoo.nemo.ui.theme.NEPL_GRAY_50
import org.junwoo.nemo.ui.theme.NEPL_GRAY_60
import org.junwoo.nemo.ui.theme.NEPL_GREEN
import org.junwoo.nemo.ui.theme.pretendardFamily
import org.junwoo.nemo.ui.view.DepartureTimePickerDialog
import org.junwoo.nemo.ui.view.KakaoMapView
import org.junwoo.nemo.ui.view.ReorderableLocationComponent

@Composable
fun PlanDetailScreen(
    onBack: () -> Unit,
    onClick: () -> Unit
) {
    var dialogShown by remember { mutableStateOf(false) }
    var selectedHour by remember {
        mutableStateOf(
            Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).hour
        )
    }
    var dropdownExpanded by remember { mutableStateOf(false) }
    var selectedMinute by remember {
        mutableStateOf(
            Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).minute
        )
    }
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Row {
            Image(
                modifier = Modifier.clickable {
                    onBack()
                },
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = null
            )
            Spacer(modifier = Modifier.weight(1f))
            Box {
                Image(
                    modifier = Modifier.clickable {
                        dropdownExpanded = true
                    },
                    painter = painterResource(id = R.drawable.ic_menu),
                    contentDescription = null
                )

                DropdownMenu(
                    expanded = dropdownExpanded,
                    onDismissRequest = { dropdownExpanded = false },
                ) {

                    DropdownMenuItem(
                        text = {
                            Row {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_share),
                                    contentDescription = null
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "공유하기",
                                    fontFamily = pretendardFamily,
                                    color = NEPL_GRAY_50,
                                    fontWeight = FontWeight(500),
                                    fontSize = 14.sp
                                )
                            }
                        },
                        onClick = {
                            context.sendDefaultFeedMessage(
                                Plan(
                                    departureDateTime = "04:30",
                                    thumbnail = "",
                                    id = 1,
                                    public = false,
                                    title = "성산에서 행운을 빌어요",
                                    user = User(
                                        address = "",
                                        createdDate = "",
                                        email = "",
                                        id = 1,
                                        modifiedDate = "",
                                        name = "",
                                        nickname = "",
                                        password = ""
                                    )
                                ),
                                8
                            )
                            dropdownExpanded = false
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "성산에서 행운을 빌어요",
            fontFamily = pretendardFamily,
            fontWeight = FontWeight.Bold,
            color = NEPL_BLACK,
            fontSize = 18.sp
        )
        Text(
            text = "등록 경유지 8개",
            fontFamily = pretendardFamily,
            fontWeight = FontWeight(500),
            color = NEPL_GRAY_60
        )
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {

            KakaoMapView(
                modifier = Modifier
                    .aspectRatio(280 / 256f)
                    .clip(RoundedCornerShape(12.dp)),
                initialLatitude = 66.9,
                initialLongitude = 33.33
            )
            Row(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(top = 12.dp)
                    .wrapContentHeight()
                    .background(color = NEPL_GREEN, RoundedCornerShape(15.dp)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.padding(horizontal = 25.dp, vertical = 16.dp)) {
                    Text(
                        text = "에상 시간",
                        fontFamily = pretendardFamily,
                        fontWeight = FontWeight(500),
                        color = NEPL_GRAY_50,
                        fontSize = 10.sp
                    )
                    Text(
                        text = "1시간 45분",
                        fontFamily = pretendardFamily,
                        fontWeight = FontWeight(500),
                        color = NEPL_BLACK,
                        fontSize = 16.sp
                    )
                }
                Divider(
                    Modifier
                        .width(1.dp)
                        .height(25.dp)
                )
                Column(modifier = Modifier.padding(horizontal = 25.dp)) {
                    Text(
                        text = "거리",
                        fontFamily = pretendardFamily,
                        fontWeight = FontWeight(500),
                        color = NEPL_GRAY_50,
                        fontSize = 10.sp
                    )
                    Text(
                        text = "23.5km",
                        fontFamily = pretendardFamily,
                        fontWeight = FontWeight(500),
                        color = NEPL_BLACK,
                        fontSize = 16.sp
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(20.dp))
            Icon(painter = painterResource(id = R.drawable.ic_time), contentDescription = null)
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "출발 시간")
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = { dialogShown = true },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = NEPL_GRAY_10
                )
            ) {
                Text(
                    text = "$selectedHour:${String.format("%02d", selectedMinute)}",
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = pretendardFamily,
                    fontSize = 18.sp,
                    color = NEPL_GRAY_60
                )
            }
        }
        ReorderableLocationComponent()
        Spacer(modifier = Modifier.weight(1f))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = NEPL_GREEN
            )
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "리스트 등록",
                    fontFamily = pretendardFamily,
                    fontWeight = FontWeight(500),
                    fontSize = 14.sp,
                    color = NEPL_BLACK
                )
                Icon(
                    imageVector = Icons.Default.Add,
                    tint = NEPL_BLACK,
                    contentDescription = null
                )
            }
        }
    }
    if (dialogShown) {
        Dialog(onDismissRequest = { dialogShown = false }) {
            DepartureTimePickerDialog(
                hour = selectedHour,
                minute = selectedMinute,
                onDateSelected = { hour, minute ->
                    dialogShown = false
                    selectedHour = hour
                    selectedMinute = minute
                })
        }
    }
}