package com.dica.rickandmortycompose

import android.app.Application
import com.dica.rickandmortycompose.data.module.dataModule
import com.dica.rickandmortycompose.ui.module.uiModel
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(dataModule, uiModel)
        }

    }
}