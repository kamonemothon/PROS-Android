package org.junwoo.nemo.ui.uimodel

import androidx.annotation.DrawableRes
import org.junwoo.nemo.R

sealed class BottomNavItem(
    val title: String,
    @DrawableRes val icon: Int,
    val screenRoute: String
) {

    object Diary: BottomNavItem("AI 그림일기", icon = R.drawable.ic_book_closed, "diary")
    object Plan: BottomNavItem("여행 플랜", icon = R.drawable.ic_cart, "createPlan")
    object PlanList: BottomNavItem("플랜 리스트", icon = R.drawable.ic_book_open, "planList")
}

val items = listOf(
    BottomNavItem.Diary,
    BottomNavItem.Plan,
    BottomNavItem.PlanList
)