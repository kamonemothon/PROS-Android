package org.junwoo.nemo.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.junwoo.nemo.ui.screen.planDetail.PlanDetailScreen
import org.junwoo.nemo.ui.screen.select.SelectScreen

@Composable
fun MainNavHost(
    navHostController: NavHostController = rememberNavController()
) {
    NavHost(navController = navHostController, startDestination = "select") {
        composable("select") {
            SelectScreen {
                navHostController.navigate("planDetail")
            }
        }
        composable("planDetail") {
            PlanDetailScreen(onClick = {
                navHostController.navigate("route")
            }, onBack =  {
                navHostController.popBackStack()
            })
        }
    }
}