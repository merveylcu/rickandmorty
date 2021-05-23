package com.merveylcu.rickandmorty.data.model.character

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterResponse(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String,
    val results: List<Character>
) : Parcelable
