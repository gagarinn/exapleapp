package net.demo.exampleapp

import android.app.Application
import net.demo.ip.api.data.di.ipApiDataModule
import net.demo.ip.api.ui.di.ipApiUiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ExampleApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@ExampleApplication)
            modules(ipApiUiModule + ipApiDataModule)
        }
    }
}