package com.merveylcu.rickandmorty.ui.character.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.merveylcu.rickandmorty.data.model.character.Character
import com.merveylcu.rickandmorty.data.repo.CharacterRepo
import com.merveylcu.rickandmorty.service.util.AppResult
import com.merveylcu.rickandmorty.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class CharacterDetailViewModel(private val repository: CharacterRepo) : BaseViewModel() {

    val character = MutableLiveData<Character?>()

    fun getCharacter(characterId: Int) {
        viewModelScope.launch {
            when (val result = repository.getCharacter(characterId)) {
                is AppResult.Success -> {
                    character.value = result.successData
                }
                is AppResult.Error -> {
                    state.value = CharacterDetailVMState.ShowError(result.message)
                }
            }
        }
    }

}