package org.junwoo.nemo.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.kakaomobility.knsdk.KNSDK
import dagger.hilt.android.AndroidEntryPoint
import org.junwoo.nemo.ui.theme.NEMOTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initKakaoSDK()
        setContent {
            NEMOTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    PlanDetailScreen(onClick = {
//
//                    }, onBack = {
//
//                    })
                    MainNavHost()
                }
            }
        }
    }

    private fun initKakaoSDK() {
        KNSDK.apply {
            install(application, "")
            initializeWithAppKey("e1772a2182c48fdcace662c0a504c437", "1.0.0", aCompletion = {

            })
        }
    }
}