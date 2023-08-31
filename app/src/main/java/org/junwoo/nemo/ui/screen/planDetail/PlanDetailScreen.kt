package org.junwoo.nemo.ui.screen.planDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.junwoo.nemo.R
import org.junwoo.nemo.ui.theme.NEPL_BLACK
import org.junwoo.nemo.ui.theme.NEPL_GRAY_50
import org.junwoo.nemo.ui.theme.NEPL_GRAY_60
import org.junwoo.nemo.ui.theme.NEPL_GREEN
import org.junwoo.nemo.ui.theme.pretendardFamily
import org.junwoo.nemo.ui.view.DepartureTimePickerDialog
import org.junwoo.nemo.ui.view.ReorderableLocationComponent

@Composable
fun PlanDetailScreen(
    onBack: () -> Unit,
    onClick: () -> Unit
) {
    var dialogShown by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = "여행 플랜 리스트",
            fontFamily = pretendardFamily,
            fontWeight = FontWeight(500),
            color = NEPL_BLACK,
            fontSize = 18.sp
        )
        Text(
            text = "등록된 장소 10개",
            fontFamily = pretendardFamily,
            fontWeight = FontWeight(500),
            color = NEPL_GRAY_60
        )
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.TopCenter
        ) {
//            AndroidView(
//                modifier = Modifier
//                    .aspectRatio(280/256f),
//                factory = { context ->
//                    val view = LayoutInflater.from(context).inflate(R.layout.map_view, null)
//                    val map = view.findViewById<MapView>(R.id.ui_map)
//                    map.apply {
//                        start()
//                    }
//                })
            Image(
                modifier = Modifier
                    .aspectRatio(280/256f),
                painter = painterResource(id = R.drawable.image_detail_placeholder),
                contentDescription = null
            )
            Row(
                modifier = Modifier
                    .wrapContentWidth()
                    .height(52.dp)
                    .background(color = NEPL_GREEN, RoundedCornerShape(15.dp)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.padding(horizontal = 25.dp)) {
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
                        .fillMaxHeight()
                        .width(1.dp)
                        .padding(vertical = 14.dp)
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
        ) {
            Icon(painter = painterResource(id = R.drawable.ic_time), contentDescription = null)
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "출발 시간")
            Spacer(modifier = Modifier.weight(1f))
            Button(onClick = { /*TODO*/ }) {

            }
        }
        ReorderableLocationComponent()
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
        DepartureTimePickerDialog(onDialogDismissed = { dialogShown = false }, onDateSelected = { hour, minute ->
        })
    }
}