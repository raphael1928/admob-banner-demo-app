package br.com.raphael.admobbannerkitconsumer

import android.app.Application
import br.com.raphael.admobbannerkit.core.AdMobManager
import br.com.raphael.admobbannerkitconsumer.di.appModule
import br.com.raphael.admobbannerkitconsumer.di.ktorModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, ktorModule))
        }
        AdMobManager.initialize(this)
    }
}
