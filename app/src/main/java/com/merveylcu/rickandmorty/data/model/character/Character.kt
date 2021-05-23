package com.merveylcu.rickandmorty.data.model.character

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: OriginLocation,
    val location: LocationEndPoint,
    val image: String,
    val episode: ArrayList<String>,
    val url: String,
    val created: String
) : Parcelable

@Parcelize
data class OriginLocation(
    val name: String,
    val url: String
) : Parcelable

@Parcelize
data class LocationEndPoint(
    val name: String,
    val url: String
) : Parcelable