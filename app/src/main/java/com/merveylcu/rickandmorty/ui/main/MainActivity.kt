package com.merveylcu.rickandmorty.ui.main

import android.view.MenuItem
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.merveylcu.rickandmorty.R
import com.merveylcu.rickandmorty.databinding.ActivityMainBinding
import com.merveylcu.rickandmorty.ui.base.BaseActivity
import com.merveylcu.rickandmorty.ui.base.VMState
import org.koin.android.ext.android.get

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    private lateinit var navController: NavController

    override val layoutRes: Int
        get() = R.layout.activity_main

    override val viewModel: MainViewModel = get()

    override fun initUI() {
        navController = findNavController(R.id.nav_host_fragment)
        binding?.navView?.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.menu_home_page -> showNavView()
                R.id.menu_characters -> showNavView()
                R.id.menu_episodes -> showNavView()
                R.id.menu_locations -> showNavView()
                else -> hideNavView()
            }
        }

        setupActionBarWithNavController(navController)
    }

    override fun initListener() {

    }

    override fun onChangedScreenState(state: VMState) {

    }

    private fun showNavView() {
        binding?.navView?.visibility = View.VISIBLE

    }

    private fun hideNavView() {
        binding?.navView?.visibility = View.GONE

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                navController.navigateUp()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}