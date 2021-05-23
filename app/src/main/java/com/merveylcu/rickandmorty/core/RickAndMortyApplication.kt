package com.merveylcu.rickandmorty.core

import android.app.Application
import com.merveylcu.rickandmorty.module.apiModule
import com.merveylcu.rickandmorty.module.networkModule
import com.merveylcu.rickandmorty.module.repositoryModule
import com.merveylcu.rickandmorty.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RickAndMortyApplication : Application() {

    private val modules = arrayOf(apiModule, networkModule, repositoryModule, viewModelModule)

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@RickAndMortyApplication)
            koin.loadModules(
                modules.toList()
            )
        }
    }

}