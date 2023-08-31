package org.junwoo.nemo.ui.screen.select

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.junwoo.nemo.ui.screen.planlist.PlanListScreen
import org.junwoo.nemo.ui.screen.createplan.CreatePlanScreen
import org.junwoo.nemo.ui.screen.diary.DiaryScreen

@Composable
fun MainScreenNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController(),
    onDetailClicked: () -> Unit
) {
    NavHost(
        modifier = modifier, navController = navHostController, startDestination = "diary") {
        composable("diary") {
            DiaryScreen {
                onDetailClicked()
            }
        }
        composable("createPlan") {
            CreatePlanScreen()
        }
        composable("planList") {
            PlanListScreen()
        }
    }
}