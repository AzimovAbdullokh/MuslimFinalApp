package com.example.muslimfinalapp.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.muslimfinalapp.R
import com.example.muslimfinalapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val navHostFragment: NavHostFragment by lazy(LazyThreadSafetyMode.NONE) {
        supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_activity_main)
                as NavHostFragment
    }

    private val navController: NavController
        get() = navHostFragment.navController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setWindowToFullScreen()

        binding.bottomNavigationView.setupWithNavController(navController)
        initBottomNavigationView(navController)
    }

    private fun setWindowToFullScreen() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }

    private fun initBottomNavigationView(navController: NavController) {
        binding.bottomNavigationView.setOnItemReselectedListener {
            val currentLocation = navController.currentDestination?.id
            val currentLabel = navController.currentDestination?.label
            when (it.itemId) {
                R.id.main_navigation -> {
                    if (currentLocation != R.id.home_screen_main) {
                        navController.popBackStack(R.id.home_screen_main, false)
                        currentLocation?.apply(navController::navigate)
                    } else {
                        findViewById<RecyclerView>(com.example.main_screen.R.id.booksRecyclerView)
                            ?.smoothScrollToPosition(0)
                    }

                }
            }
        }
    }

}