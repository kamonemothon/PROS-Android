@file:OptIn(ExperimentalFoundationApi::class)

package org.junwoo.nemo.ui.screen.planlist

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import org.junwoo.nemo.R
import org.junwoo.nemo.ui.theme.NEPL_BLACK
import org.junwoo.nemo.ui.theme.NEPL_GRAY_30
import org.junwoo.nemo.ui.theme.NEPL_GRAY_50
import org.junwoo.nemo.ui.theme.NEPL_GRAY_60
import org.junwoo.nemo.ui.theme.pretendardFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlanListScreen(
    viewModel: PlanListViewModel = hiltViewModel(),
    onDetailClicked: () -> Unit
) {
    var text by remember {
        mutableStateOf("")
    }
    val planList by viewModel.planList.collectAsStateWithLifecycle()
    val gridList = planList.withIndex().groupBy { it.index / 6 }
        .map { it.value.map { value -> value.value } }
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier.padding(start = 20.dp),
            text = "플랜 리스트",
            fontFamily = pretendardFamily,
            fontSize = 20.sp,
            fontWeight = FontWeight(700),
            color = Color(0xFF373737)
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            shape = RoundedCornerShape(15.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
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
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)) {
            Button(
                onClick = { /*TODO*/ },
                border = BorderStroke(1.dp, NEPL_GRAY_50),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.White,
                    contentColor = NEPL_GRAY_50
                )
            ) {
                Text(text = "마이 리스트")
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = { /*TODO*/ },
                border = BorderStroke(1.dp, NEPL_GRAY_50),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.White,
                    contentColor = NEPL_GRAY_50
                )
            ) {
                Text(text = "공유 리스트")
            }
        }
        Spacer(modifier = Modifier.height(22.dp))
        HorizontalPager(
            modifier = Modifier.weight(1f),
            pageCount = planList.size / 6
        ) { page ->
            LazyVerticalGrid(
                modifier = Modifier.fillMaxSize(),
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(horizontal = 20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(gridList[page]) {
                    Box(
                        modifier = Modifier
                            .aspectRatio(156 / 130f)
                            .background(NEPL_BLACK, RoundedCornerShape(12.dp))
                            .clickable {
                                onDetailClicked()
                            }
                        ,
                        contentAlignment = Alignment.BottomStart
                    ) {
                        AsyncImage(
                            modifier = Modifier.fillMaxSize(),
                            model = it.thumbnail,
                            contentDescription =null
                        )
                        Row(Modifier.padding(bottom = 10.dp, start = 12.dp)) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_play),
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Image(
                                painter = painterResource(id = R.drawable.ic_more),
                                contentDescription = null
                            )
                        }
                    }
                }
            }
        }

    }
}