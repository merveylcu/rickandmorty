package com.merveylcu.rickandmorty.ui.character

import com.merveylcu.rickandmorty.data.model.character.Character
import com.merveylcu.rickandmorty.ui.base.VMState

interface CharactersVMState : VMState {
    class SetCharacterList : CharactersVMState
    class OpenCharacterDetail(val character: Character) : CharactersVMState
    class ShowError(val message: String) : CharactersVMState
}