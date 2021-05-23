package com.merveylcu.rickandmorty.data.repo

import android.content.Context
import com.merveylcu.rickandmorty.data.model.character.Character
import com.merveylcu.rickandmorty.data.model.character.CharacterResponse
import com.merveylcu.rickandmorty.service.api.AppApi
import com.merveylcu.rickandmorty.service.util.AppResult
import com.merveylcu.rickandmorty.service.util.NetworkHandler.sendRequest

interface CharacterRepo {
    suspend fun getCharacters(): AppResult<CharacterResponse>
    suspend fun getCharactersAsPage(page: Int): AppResult<ArrayList<Character>>
    suspend fun getCharacter(id: Int): AppResult<Character>
}

class CharacterRepoImpl(
    private val context: Context,
    private val api: AppApi
) :
    CharacterRepo {

    override suspend fun getCharacters(): AppResult<CharacterResponse> {
        return sendRequest(context, { api.getCharacters() })
    }

    override suspend fun getCharactersAsPage(page: Int): AppResult<ArrayList<Character>> {
        return sendRequest(context, { api.getCharactersAsPage(page) })
    }

    override suspend fun getCharacter(id: Int): AppResult<Character> {
        return sendRequest(context, { api.getCharacter(id) })
    }

}