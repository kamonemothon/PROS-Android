package org.junwoo.nemo.ui.screen.select

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import org.junwoo.nemo.ui.uimodel.items

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectScreen(onDetailClicked: () -> Unit) {
    val navController = rememberNavController()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        MainScreenNavHost(
            modifier = Modifier.weight(1f),
            onDetailClicked = onDetailClicked,
            navHostController = navController
        )
        Row(
            Modifier
                .background(Color(0xFFBFFF56), shape = RoundedCornerShape(32.dp))
                .height(64.dp)
                .padding(horizontal = 40.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEach {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .clickable {
                            navController.navigate(it.screenRoute) {
                                navController.graph.startDestinationRoute?.let {
                                    popUpTo(it) { saveState = true }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
//                    Icon(painter = painterResource(id = it.icon), contentDescription = null)
                    Text(text = it.title)
                }
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
    }
}