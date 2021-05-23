package com.merveylcu.rickandmorty.service.api

import com.merveylcu.rickandmorty.data.model.character.Character
import com.merveylcu.rickandmorty.data.model.character.CharacterResponse
import com.merveylcu.rickandmorty.data.model.episode.Episode
import com.merveylcu.rickandmorty.data.model.episode.EpisodeResponse
import com.merveylcu.rickandmorty.data.model.location.Location
import com.merveylcu.rickandmorty.data.model.location.LocationResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AppApi {

    //character
    @GET("/api/character")
    suspend fun getCharacters(): Response<CharacterResponse>

    @GET("/api/character")
    suspend fun getCharactersAsPage(@Query("page") page: Int): Response<ArrayList<Character>>

    @GET("/api/character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): Response<Character>

    //location
    @GET("/api/location")
    suspend fun getLocations(): Response<LocationResponse>

    @GET("/api/location")
    suspend fun getLocationsAsPage(@Query("page") page: Int): Response<ArrayList<Location>>

    @GET("/api/location/{id}")
    suspend fun getLocation(@Path("id") id: Int): Response<Location>

    //episode
    @GET("/api/episode")
    suspend fun getEpisodes(): Response<EpisodeResponse>

    @GET("/api/episode")
    suspend fun getEpisodesAsPage(@Query("page") page: Int): Response<ArrayList<Episode>>

    @GET("/api/episode/{id}")
    suspend fun getEpisode(@Path("id") id: Int): Response<Episode>

}