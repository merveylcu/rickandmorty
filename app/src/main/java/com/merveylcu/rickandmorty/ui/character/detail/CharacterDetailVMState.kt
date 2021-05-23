package com.merveylcu.rickandmorty.ui.character.detail

import com.merveylcu.rickandmorty.ui.base.VMState

interface CharacterDetailVMState : VMState {
    class ShowError(val message: String) : CharacterDetailVMState
}
