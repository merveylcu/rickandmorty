package com.merveylcu.rickandmorty.data.model.episode

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EpisodeResponse(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String,
    val results: List<Episode>
) : Parcelable