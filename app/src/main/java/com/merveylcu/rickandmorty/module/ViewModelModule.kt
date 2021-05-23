package com.merveylcu.rickandmorty.module

import com.merveylcu.rickandmorty.ui.base.BaseViewModel
import com.merveylcu.rickandmorty.ui.character.CharactersViewModel
import com.merveylcu.rickandmorty.ui.character.detail.CharacterDetailViewModel
import com.merveylcu.rickandmorty.ui.episode.EpisodesViewModel
import com.merveylcu.rickandmorty.ui.homepage.HomePageViewModel
import com.merveylcu.rickandmorty.ui.location.LocationsViewModel
import com.merveylcu.rickandmorty.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { BaseViewModel() }
    viewModel { MainViewModel() }
    viewModel { HomePageViewModel() }
    viewModel { CharactersViewModel(get()) }
    viewModel { EpisodesViewModel() }
    viewModel { LocationsViewModel() }
    viewModel { CharacterDetailViewModel(get()) }

}