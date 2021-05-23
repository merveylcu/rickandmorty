package com.merveylcu.rickandmorty.ui.base

import androidx.lifecycle.ViewModel
import com.merveylcu.rickandmorty.util.SingleLiveEvent

open class BaseViewModel : ViewModel() {

    val state = SingleLiveEvent<VMState>()

}