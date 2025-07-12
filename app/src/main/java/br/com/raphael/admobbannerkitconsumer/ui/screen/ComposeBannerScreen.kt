package br.com.raphael.admobbannerkitconsumer.ui.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import br.com.raphael.admobbannerkit.core.model.AdEvent
import br.com.raphael.admobbannerkit.core.model.AdEventListener
import br.com.raphael.admobbannerkit.core.ui.AdBanner
import br.com.raphael.admobbannerkitconsumer.presentation.MovieViewModel
import coil.compose.AsyncImage
import com.valentinilk.shimmer.ShimmerBounds
import com.valentinilk.shimmer.shimmer
import com.valentinilk.shimmer.rememberShimmer
import org.koin.androidx.compose.koinViewModel

@Composable
fun ComposeBannerScreen() {
    val viewModel: MovieViewModel = koinViewModel()
    val movie by viewModel.movie.collectAsState()

    var adLoading by remember { mutableStateOf(true) }
    val shimmerInstance = rememberShimmer(shimmerBounds = ShimmerBounds.View)

    LaunchedEffect(Unit) {
        viewModel.loadMovie("Cidade de Deus")
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val isMovieLoading = movie == null

            if (isMovieLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .shimmer(shimmerInstance)
                        .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
                )

                Spacer(modifier = Modifier.height(16.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(24.dp)
                        .shimmer(shimmerInstance)
                        .background(Color.LightGray, shape = RoundedCornerShape(4.dp))
                )

                Spacer(modifier = Modifier.height(8.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .shimmer(shimmerInstance)
                        .background(Color.LightGray, shape = RoundedCornerShape(4.dp))
                )
            } else {
                AsyncImage(
                    model = "https://image.tmdb.org/t/p/w500${movie?.posterPath}",
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = movie!!.title,
                    style = MaterialTheme.typography.headlineSmall
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = movie!!.overview,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                AdBanner(
                    adEventListener = AdEventListener { event ->
                        when (event) {
                            AdEvent.Loading -> {
                                adLoading = true
                                Log.d("AdEvent", "Ad loading")
                            }
                            AdEvent.Loaded -> {
                                adLoading = false
                                Log.d("AdEvent", "Ad loaded")
                            }
                            is AdEvent.FailedToLoad -> Log.e("AdEvent", "Ad failed to load: ${event.errorCode}")
                            AdEvent.Opened -> Log.d("AdEvent", "Ad opened")
                            AdEvent.Clicked -> Log.d("AdEvent", "Ad clicked")
                            AdEvent.Closed -> Log.d("AdEvent", "Ad closed")
                            AdEvent.Impression -> Log.d("AdEvent", "Ad impression")
                            AdEvent.NotInitialized -> Log.d("AdEvent", "Ad not initialized")
                        }
                    }
                )

                if (adLoading) {
                    Box(
                        modifier = Modifier
                            .matchParentSize()
                            .shimmer(shimmerInstance)
                            .background(MaterialTheme.colorScheme.surfaceVariant)
                    )
                }
            }

        }
    }
}
