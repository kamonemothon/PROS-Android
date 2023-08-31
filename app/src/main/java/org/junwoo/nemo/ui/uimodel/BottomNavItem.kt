package org.junwoo.nemo.ui.uimodel

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter

sealed class BottomNavItem(
    val title: String,
    val icon: Int,
    val screenRoute: String
) {

    object Diary: BottomNavItem("AI 그림일기", 0, "diary")
    object Plan: BottomNavItem("여행 플랜", icon = 1, "createPlan")
    object PlanList: BottomNavItem("플랜 리스트", icon = 2, "planList")
}

val items = listOf(
    BottomNavItem.Diary,
    BottomNavItem.Plan,
    BottomNavItem.PlanList
)