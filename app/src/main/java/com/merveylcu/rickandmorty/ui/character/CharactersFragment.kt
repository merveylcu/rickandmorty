package com.merveylcu.rickandmorty.ui.character

import android.view.View
import androidx.navigation.fragment.findNavController
import com.merveylcu.rickandmorty.R
import com.merveylcu.rickandmorty.databinding.FragmentCharactersBinding
import com.merveylcu.rickandmorty.ui.base.BaseFragment
import com.merveylcu.rickandmorty.ui.base.VMState
import com.merveylcu.rickandmorty.util.extensions.dialog
import com.merveylcu.rickandmorty.util.extensions.getStr
import org.koin.android.ext.android.get

class CharactersFragment : BaseFragment<CharactersViewModel, FragmentCharactersBinding>() {

    override val layoutRes: Int
        get() = R.layout.fragment_characters

    override val viewModel: CharactersViewModel = get()

    override fun onChangedScreenState(state: VMState) {
        when (state) {
            is CharactersVMState.SetCharacterList -> {
                binding?.rvCharacters?.adapter = viewModel.characterListAdapter
                viewModel.characterListAdapter?.notifyDataSetChanged()
            }
            is CharactersVMState.OpenCharacterDetail -> {
                findNavController().navigate(
                    CharactersFragmentDirections.actionMenuCharacterToCharacterDetailFragment(
                        state.character.id
                    )
                )
            }
            is CharactersVMState.ShowError -> {
                dialog(state.message) {
                    positiveButton(getStr(R.string.ok)) {

                    }
                }.show()
            }
        }
    }

    override fun initUI(view: View) {
        viewModel.getCharacters()
    }

    override fun initListener() {

    }

}