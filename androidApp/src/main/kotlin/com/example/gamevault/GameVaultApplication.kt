package com.example.gamevault

import android.app.Application
import com.example.gamevault.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class GameVaultApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidLogger(Level.INFO)
            androidContext(this@GameVaultApplication)
        }
    }
}