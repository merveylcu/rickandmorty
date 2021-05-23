package com.merveylcu.rickandmorty.ui.location

import android.view.View
import com.merveylcu.rickandmorty.R
import com.merveylcu.rickandmorty.databinding.FragmentLocationsBinding
import com.merveylcu.rickandmorty.ui.base.BaseFragment
import com.merveylcu.rickandmorty.ui.base.VMState
import com.merveylcu.rickandmorty.ui.homepage.HomePageViewModel
import org.koin.android.ext.android.get

class LocationsFragment : BaseFragment<LocationsViewModel, FragmentLocationsBinding>() {

    override val layoutRes: Int
        get() = R.layout.fragment_locations

    override val viewModel: LocationsViewModel = get()

    override fun initUI(view: View) {

    }

    override fun initListener() {

    }

    override fun onChangedScreenState(state: VMState) {

    }

}