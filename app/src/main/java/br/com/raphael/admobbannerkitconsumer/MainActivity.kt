package br.com.raphael.admobbannerkitconsumer

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.*
import br.com.raphael.admobbannerkitconsumer.ui.screen.ComposeBannerScreen
import br.com.raphael.admobbannerkitconsumer.ui.screen.XMLBannerActivity
import br.com.raphael.admobbannerkitconsumer.ui.theme.AdMobBannerKitConsumerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdMobBannerKitConsumerTheme {
                AppNavGraph(onOpenXML = {
                    startActivity(Intent(this@MainActivity, XMLBannerActivity::class.java))
                })
            }
        }
    }
}

@Composable
fun AppNavGraph(onOpenXML: () -> Unit) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MainScreen(
                onXMLClick = onOpenXML,
                onComposeClick = { navController.navigate("compose") }
            )
        }
        composable("compose") {
            ComposeBannerScreen()
        }
    }
}

@Composable
fun MainScreen(
    onXMLClick: () -> Unit,
    onComposeClick: () -> Unit
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = onXMLClick) {
                Text("Banner via XML")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onComposeClick) {
                Text("Abrir tela Compose")
            }
        }
    }
}
