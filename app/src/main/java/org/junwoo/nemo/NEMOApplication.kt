package org.junwoo.nemo

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NEMOApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        KakaoSdk.init(this, "e1772a2182c48fdcace662c0a504c437")
    }
}