package com.ricindigus.cambista

import android.app.Application
import com.ricindigus.cambista.di.applicationModule
import com.ricindigus.cambista.modules.authentication.di.authenticationModule
import com.ricindigus.cambista.modules.main.di.homeModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CambistaApp: Application() {
    companion object {
        private lateinit var instance: CambistaApp
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin {
            androidLogger()
            androidContext(this@CambistaApp)
            modules(applicationModule, authenticationModule, homeModule)
        }
    }
}

