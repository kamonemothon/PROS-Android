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
import androidx.compose.ui.unit.dp
import org.burnoutcrew.reorderable.ReorderableItem
import org.burnoutcrew.reorderable.detectReorderAfterLongPress
import org.burnoutcrew.reorderable.rememberReorderableLazyGridState
import org.burnoutcrew.reorderable.reorderable
import org.junwoo.nemo.R
import org.junwoo.nemo.ui.theme.NEPL_GRAY_30
import org.junwoo.nemo.ui.theme.NEPL_GRAY_40

@Composable
fun ReorderableLocationComponent(modifier: Modifier = Modifier) {
    var data by remember {
        mutableStateOf(mutableListOf<Int?>(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10).apply {
            while (size == 11) {
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
                            painter = painterResource(id = R.drawable.ic_cafe),
                            contentDescription = null
                        )

                        Text(text = "$items")
                    }
                }
            }
        }
    }
}