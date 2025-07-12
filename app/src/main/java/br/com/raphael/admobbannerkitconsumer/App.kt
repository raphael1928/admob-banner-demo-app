package br.com.raphael.admobbannerkitconsumer

import android.app.Application
import br.com.raphael.admobbannerkit.core.AdMobManager

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        AdMobManager.initialize(this)
    }
}
