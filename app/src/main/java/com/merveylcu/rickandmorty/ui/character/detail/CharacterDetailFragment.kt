package com.merveylcu.rickandmorty.ui.character.detail

import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.merveylcu.rickandmorty.R
import com.merveylcu.rickandmorty.databinding.FragmentCharacterDetailBinding
import com.merveylcu.rickandmorty.ui.base.BaseFragment
import com.merveylcu.rickandmorty.ui.base.VMState
import com.merveylcu.rickandmorty.util.extensions.dialog
import com.merveylcu.rickandmorty.util.extensions.getStr
import org.koin.android.ext.android.get

class CharacterDetailFragment :
    BaseFragment<CharacterDetailViewModel, FragmentCharacterDetailBinding>() {

    private val characterDetailFragmentArgs: CharacterDetailFragmentArgs by navArgs()

    override val viewModel: CharacterDetailViewModel = get()

    override val layoutRes: Int
        get() = R.layout.fragment_character_detail

    override fun onChangedScreenState(state: VMState) {
        viewModel.state.observe(viewLifecycleOwner, {
            when (it) {
                is CharacterDetailVMState.ShowError -> {
                    dialog(it.message) {
                        positiveButton(getStr(R.string.ok)) {

                        }
                    }.show()
                }
            }
        })
    }

    override fun initUI(view: View) {
        val characterId = characterDetailFragmentArgs.characterId
        viewModel.getCharacter(characterId)
    }

    override fun initListener() {
        viewModel.character.observe(this, Observer {
            it?.let {
                binding?.character = it
                binding?.invalidateAll()
            }
        })
    }

}