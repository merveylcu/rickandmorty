package com.merveylcu.rickandmorty.data.repo

import android.content.Context
import com.merveylcu.rickandmorty.data.model.episode.Episode
import com.merveylcu.rickandmorty.data.model.episode.EpisodeResponse
import com.merveylcu.rickandmorty.service.api.AppApi
import com.merveylcu.rickandmorty.service.util.AppResult
import com.merveylcu.rickandmorty.service.util.NetworkHandler.sendRequest

interface EpisodeRepo {
    suspend fun getLocations(): AppResult<EpisodeResponse>
    suspend fun getEpisodesAsPage(page: Int): AppResult<ArrayList<Episode>>
    suspend fun getEpisode(id: Int): AppResult<Episode>
}

class EpisodeRepoImpl(
    private val context: Context,
    private val api: AppApi
) :
    EpisodeRepo {

    override suspend fun getLocations(): AppResult<EpisodeResponse> {
        return sendRequest(context, { api.getEpisodes() })
    }

    override suspend fun getEpisodesAsPage(page: Int): AppResult<ArrayList<Episode>> {
        return sendRequest(context, { api.getEpisodesAsPage(page) })
    }

    override suspend fun getEpisode(id: Int): AppResult<Episode> {
        return sendRequest(context, { api.getEpisode(id) })
    }
}