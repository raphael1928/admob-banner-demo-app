package br.com.raphael.admobbannerkitconsumer.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.raphael.admobbannerkit.core.model.AdEvent
import br.com.raphael.admobbannerkit.core.model.AdEventListener
import br.com.raphael.admobbannerkit.core.ui.AdBanner

@Composable
fun ComposeBannerScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text("Banner via Compose")
            Spacer(modifier = Modifier.height(16.dp))

            AdBanner(
                adEventListener = AdEventListener { event ->
                    when (event) {
                        AdEvent.Loading -> Log.d("AdEvent", "Ad loading")
                        AdEvent.Loaded -> Log.d("AdEvent", "Ad loaded")
                        is AdEvent.FailedToLoad -> Log.e("AdEvent", "Ad failed to load: ${event.errorCode}")
                        AdEvent.Opened -> Log.d("AdEvent", "Ad opened")
                        AdEvent.Clicked -> Log.d("AdEvent", "Ad clicked")
                        AdEvent.Closed -> Log.d("AdEvent", "Ad closed")
                        AdEvent.Impression -> Log.d("AdEvent", "Ad impression")
                        AdEvent.NotInitialized -> Log.d("AdEvent", "Ad not initialized")
                    }
                }
            )
        }
    }
}

