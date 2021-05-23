package com.merveylcu.rickandmorty.ui.homepage

import android.view.View
import com.merveylcu.rickandmorty.R
import com.merveylcu.rickandmorty.databinding.FragmentHomePageBinding
import com.merveylcu.rickandmorty.ui.base.BaseFragment
import com.merveylcu.rickandmorty.ui.base.VMState
import org.koin.android.ext.android.get

class HomePageFragment : BaseFragment<HomePageViewModel, FragmentHomePageBinding>() {

    override val viewModel: HomePageViewModel = get()

    override val layoutRes: Int
        get() = R.layout.fragment_home_page

    override fun initUI(view: View) {

    }

    override fun initListener() {

    }

    override fun onChangedScreenState(state: VMState) {

    }

}