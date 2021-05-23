package com.merveylcu.rickandmorty.data.model.location

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LocationResponse(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String,
    val results: List<Location>
) : Parcelable
