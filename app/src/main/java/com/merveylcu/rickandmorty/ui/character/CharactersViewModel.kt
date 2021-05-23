package com.merveylcu.rickandmorty.ui.character

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.merveylcu.rickandmorty.data.model.character.Character
import com.merveylcu.rickandmorty.data.model.character.CharacterResponse
import com.merveylcu.rickandmorty.data.repo.CharacterRepo
import com.merveylcu.rickandmorty.service.util.AppResult
import com.merveylcu.rickandmorty.ui.base.BaseViewModel
import com.merveylcu.rickandmorty.ui.character.adapter.CharacterListAdapter
import com.merveylcu.rickandmorty.util.listener.OnItemClickListener
import kotlinx.coroutines.launch

class CharactersViewModel(private val repository: CharacterRepo) : BaseViewModel() {

    var characterListAdapter: CharacterListAdapter? = null
    private val characterResponse = MutableLiveData<CharacterResponse?>()

    fun getCharacters() {
        viewModelScope.launch {
            when (val result = repository.getCharacters()) {
                is AppResult.Success -> {
                    val characterList = arrayListOf<Character>()
                    characterList.addAll(result.successData.results)
                    characterListAdapter = CharacterListAdapter(characterList, onItemClick)
                    characterResponse.value = result.successData
                    state.value = CharactersVMState.SetCharacterList()
                }
                is AppResult.Error -> {
                    state.value = CharactersVMState.ShowError(result.message)
                }
            }
        }
    }

    private val onItemClick = object : OnItemClickListener {
        override fun onItemClick(item: Any?) {
            val character = item as? Character
            character?.let {
                state.value = CharactersVMState.OpenCharacterDetail(it)
            }
        }
    }

}