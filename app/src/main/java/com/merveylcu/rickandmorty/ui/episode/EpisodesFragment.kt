package com.merveylcu.rickandmorty.ui.episode

import android.view.View
import com.merveylcu.rickandmorty.R
import com.merveylcu.rickandmorty.databinding.FragmentEpisodesBinding
import com.merveylcu.rickandmorty.ui.base.BaseFragment
import com.merveylcu.rickandmorty.ui.base.VMState
import org.koin.android.ext.android.get

class EpisodesFragment : BaseFragment<EpisodesViewModel, FragmentEpisodesBinding>() {

    override val viewModel: EpisodesViewModel = get()

    override val layoutRes: Int
        get() = R.layout.fragment_episodes

    override fun initUI(view: View) {

    }

    override fun initListener() {

    }

    override fun onChangedScreenState(state: VMState) {

    }

}