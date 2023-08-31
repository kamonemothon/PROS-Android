package org.junwoo.nemo.ui.view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.burnoutcrew.reorderable.ReorderableItem
import org.burnoutcrew.reorderable.detectReorderAfterLongPress
import org.burnoutcrew.reorderable.rememberReorderableLazyGridState
import org.burnoutcrew.reorderable.reorderable
import org.junwoo.nemo.R
import org.junwoo.nemo.ui.theme.NEPL_GRAY_30
import org.junwoo.nemo.ui.theme.NEPL_GRAY_40
import org.junwoo.nemo.ui.theme.NEPL_GRAY_60
import org.junwoo.nemo.ui.theme.pretendardFamily

@Composable
fun ReorderableLocationComponent(modifier: Modifier = Modifier) {
    var data by remember {
        mutableStateOf(mutableListOf<Pair<Int, String>?>(0 to "우진해장국", 1 to  "함덕 해수용장", 2 to "이룸 미술관", 3 to "랜디스 도넛", 4 to "안녕육지사람", 5 to "숙성도", 6 to "롯데호텔", 7 to "성산일출봉").apply {
            while (count() <= 11) {
                add(null)
            }
        })
    }
    val state = rememberReorderableLazyGridState(onMove = { from, to ->
        data = data.toMutableList().apply {
            add(to.index, removeAt(from.index))
        }
    })
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        state = state.gridState,
        modifier = modifier.reorderable(state),
    ) {
        itemsIndexed(
            data,
            key = { index, _ -> index }
        ) { index, item ->
            var circleHeight by remember {
                mutableStateOf(0f)
            }
            Box(
                modifier = Modifier.aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
                    val width = size.width
                    val height = size.height.also {
                        circleHeight = it
                    }
                    when (index) {
                        0 -> drawLine(
                            NEPL_GRAY_30,
                            start = Offset(width / 2, height / 2.5f),
                            end = Offset(width, height / 2.5f)
                        )

                        3 -> {
                            drawLine(
                                NEPL_GRAY_30,
                                start = Offset(0f, height / 2.5f),
                                end = Offset(width / 2, height / 2.5f)
                            )
                            drawLine(
                                NEPL_GRAY_30,
                                start = Offset(width / 2, height / 2.5f),
                                end = Offset(width / 2, height)
                            )
                        }

                        4 -> {
                            drawLine(
                                NEPL_GRAY_30,
                                start = Offset(width / 2, height / 2.5f),
                                end = Offset(width, height / 2.5f)
                            )
                            drawLine(
                                NEPL_GRAY_30,
                                start = Offset(width / 2, height / 2.5f),
                                end = Offset(width / 2, height)
                            )
                        }

                        7 -> {
                            drawLine(
                                NEPL_GRAY_30,
                                start = Offset(0f, height / 2.5f),
                                end = Offset(width / 2, height / 2.5f)
                            )
                            drawLine(
                                NEPL_GRAY_30,
                                start = Offset(width / 2, height / 2.5f),
                                end = Offset(width / 2, 0f)
                            )
                        }

                        8 -> {
                            drawLine(
                                NEPL_GRAY_30,
                                start = Offset(width, height / 2.5f),
                                end = Offset(width / 2, height / 2.5f)
                            )
                            drawLine(
                                NEPL_GRAY_30,
                                start = Offset(width / 2, height / 2.5f),
                                end = Offset(width / 2, 0f)
                            )
                        }

                        11 -> drawLine(
                            NEPL_GRAY_30,
                            start = Offset(width / 2, height / 2.5f),
                            end = Offset(0f, height / 2.5f)
                        )

                        else -> drawLine(
                            NEPL_GRAY_30,
                            start = Offset(0f, height / 2.5f),
                            end = Offset(width, height / 2.5f)
                        )
                    }
                })
                Canvas(modifier = Modifier
                    .size(4.dp)
                    .offset(
                        0.dp, (-8).dp
                    ), onDraw = {
                    drawCircle(NEPL_GRAY_40)
                })

            }
            item?.let { items ->
                ReorderableItem(state = state, key = item, defaultDraggingModifier = Modifier) {
                    Column(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .windowInsetsPadding(WindowInsets(12.dp, 12.dp, 12.dp, 12.dp))
                            .clip(RoundedCornerShape(12.dp))
                            .detectReorderAfterLongPress(state),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {

                        Image(
                            painter = painterResource(id = when(items.first) {
                                0, 5 -> R.drawable.ic_restaurant
                                1 -> R.drawable.ic_location_etc
                                2 -> R.drawable.ic_museum
                                3, 4 -> R.drawable.ic_cafe
                                6 -> R.drawable.ic_hostel
                                7 -> R.drawable.ic_park
                                else -> R.drawable.ic_cafe
                            }),
                            contentDescription = null
                        )

                        Text(
                            text = items.second,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            fontFamily = pretendardFamily,
                            fontWeight = FontWeight.Medium,
                            color = NEPL_GRAY_60,
                            fontSize = 10.sp
                        )
                    }
                }
            }
        }
    }
}