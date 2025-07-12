package br.com.raphael.admobbannerkitconsumer.ui.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.raphael.admobbannerkitconsumer.databinding.ActivityXmlBannerBinding

class XMLBannerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityXmlBannerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityXmlBannerBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
