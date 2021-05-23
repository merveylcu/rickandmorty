package com.merveylcu.rickandmorty.data.model.location

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Location(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: ArrayList<String>,
    val url: String,
    val created: String
) : Parcelable
