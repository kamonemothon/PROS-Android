package org.junwoo.nemo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NEMOApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}