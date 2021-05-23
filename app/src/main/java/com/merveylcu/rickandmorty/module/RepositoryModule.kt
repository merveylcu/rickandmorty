package com.merveylcu.rickandmorty.module

import android.content.Context
import com.merveylcu.rickandmorty.data.repo.*
import com.merveylcu.rickandmorty.service.api.AppApi
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {

    fun provideCharacterRepository(
        context: Context,
        api: AppApi
    ): CharacterRepo {
        return CharacterRepoImpl(context, api)
    }
    single { provideCharacterRepository(androidContext(), get()) }

    fun provideEpisodeRepository(
        context: Context,
        api: AppApi
    ): EpisodeRepo {
        return EpisodeRepoImpl(context, api)
    }
    single { provideEpisodeRepository(androidContext(), get()) }

    fun provideLocationRepository(
        context: Context,
        api: AppApi
    ): LocationRepo {
        return LocationRepoImpl(context, api)
    }
    single { provideLocationRepository(androidContext(), get()) }

}