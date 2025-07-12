package br.com.raphael.admobbannerkitconsumer.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
            AdBanner()
        }
    }
}
