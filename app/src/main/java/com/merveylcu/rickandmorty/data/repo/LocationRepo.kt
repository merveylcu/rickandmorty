package com.merveylcu.rickandmorty.data.repo

import android.content.Context
import com.merveylcu.rickandmorty.data.model.location.Location
import com.merveylcu.rickandmorty.data.model.location.LocationResponse
import com.merveylcu.rickandmorty.service.api.AppApi
import com.merveylcu.rickandmorty.service.util.AppResult
import com.merveylcu.rickandmorty.service.util.NetworkHandler.sendRequest

interface LocationRepo {
    suspend fun getLocations(): AppResult<LocationResponse>
    suspend fun getLocationsAsPage(page: Int): AppResult<ArrayList<Location>>
    suspend fun getLocation(id: Int): AppResult<Location>
}

class LocationRepoImpl(
    private val context: Context,
    private val api: AppApi
) :
    LocationRepo {

    override suspend fun getLocations(): AppResult<LocationResponse> {
        return sendRequest(context, { api.getLocations() })
    }

    override suspend fun getLocationsAsPage(page: Int): AppResult<ArrayList<Location>> {
        return sendRequest(context, { api.getLocationsAsPage(page) })
    }

    override suspend fun getLocation(id: Int): AppResult<Location> {
        return sendRequest(context, { api.getLocation(id) })
    }
}