package org.junwoo.nemo.ui.view

import android.util.Log
import android.view.LayoutInflater
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.kakao.vectormap.KakaoMap
import com.kakao.vectormap.KakaoMapReadyCallback
import com.kakao.vectormap.MapLifeCycleCallback
import com.kakao.vectormap.MapView
import org.junwoo.nemo.R

@Composable
fun KakaoMapView(
    modifier: Modifier,
    initialLatitude: Double,
    initialLongitude: Double
) {
    AndroidView(
        modifier = modifier.fillMaxSize(),
        factory = { context ->
            val view = LayoutInflater.from(context).inflate(R.layout.map_view, null)
            val map = view.findViewById<MapView>(R.id.ui_map)
            map.apply {
                start(object : MapLifeCycleCallback() {
                    override fun onMapDestroy() {
                        Log.d("MyTag", "MAP INITIALIZED!")
                    }

                    override fun onMapError(error: Exception?) {
                        error?.printStackTrace()
                    }

                }, object : KakaoMapReadyCallback() {
                    override fun onMapReady(kakaoMap: KakaoMap) {
                        Log.d("MyTag", "${kakaoMap.isVisible}")
//                        val cameraUpdate = CameraUpdateFactory.newCenterPosition(
//                            LatLng.from(
//                                initialLatitude,
//                                initialLongitude
//                            )
//                        )
//                        kakaoMap.moveCamera(cameraUpdate)
                    }

                })
            }
        }
    )
}