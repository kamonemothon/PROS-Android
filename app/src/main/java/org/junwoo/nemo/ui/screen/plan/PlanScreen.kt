package org.junwoo.nemo.ui.screen.plan

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun PlanScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Row {
            Button(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = null)
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
            }
        }
        Text(text = "여행 플랜 리스트")
        Text(text = "등록된 장소 10개") // 임시저장된 거에서 가지고 오기

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(24.dp))
                .padding(40.dp)
                .aspectRatio(1f),
            contentAlignment = Alignment.TopCenter
        ) {
            MapComponent(
                modifier = Modifier.fillMaxWidth(),
                locationList = listOf(1, 2, 3, 4, 5, 6, 7)
            )

        }
    }
}

@Composable
fun TimeAllow() {

}

@Composable
fun MapComponent(
    modifier: Modifier = Modifier,
    locationList: List<Int> // 나중에 Location 모델로 하면 될듯
) { // 여기에 지도 들어가면 됨. 마커랑 이것도 같이

}