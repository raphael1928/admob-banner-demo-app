package br.com.raphael.admobbannerkitconsumer.ui.screen

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.com.raphael.admobbannerkit.api.AdEvent
import br.com.raphael.admobbannerkit.api.AdEventListener
import br.com.raphael.admobbannerkitconsumer.databinding.ActivityXmlBannerBinding

class XMLBannerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityXmlBannerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityXmlBannerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.adBannerView.setAdEventListener(AdEventListener { event ->
            when (event) {
                AdEvent.Loading -> Log.d("AdEvent", "Ad loading (XML)")
                AdEvent.Loaded -> Log.d("AdEvent", "Ad loaded (XML)")
                is AdEvent.FailedToLoad -> Log.e("AdEvent", "Ad failed to load (XML): ${event.errorCode}")
                AdEvent.Opened -> Log.d("AdEvent", "Ad opened (XML)")
                AdEvent.Clicked -> Log.d("AdEvent", "Ad clicked (XML)")
                AdEvent.Closed -> Log.d("AdEvent", "Ad closed (XML)")
                AdEvent.Impression -> Log.d("AdEvent", "Ad impression (XML)")
                AdEvent.NotInitialized -> Log.d("AdEvent", "Ad not initialized (XML)")
            }
        })
    }
}

