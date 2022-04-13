package com.example.lesson33.ui

import android.app.Application
import com.example.lesson33.serviclacator.remoteModule
import com.example.lesson33.serviclacator.repositoriesModel
import com.example.lesson33.serviclacator.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(remoteModule, repositoriesModel, viewModelModule)
        }

    }
}