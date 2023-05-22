package com.example.muslimfinalapp.app.temporary_screens.splash

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.common_api.base.BaseFragment
import com.example.muslimfinalapp.R
import com.example.muslimfinalapp.databinding.FragmentSplashBinding
import com.example.ui_core.extensions.launchOnLifecycle
import com.example.ui_core.extensions.launchWhenViewStarted
import com.example.utils_core.extensions.hide
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment :
    BaseFragment<FragmentSplashBinding, SplashViewModel>(FragmentSplashBinding::inflate) {

    override val viewModel: SplashViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
    }

    private fun observeData() = with(viewModel) {
        launchOnLifecycle { isProgressBarVisibleFlow.observe(::setProgressBarVisible) }
        launchWhenViewStarted { navigateToFlow.observe(::navigateTo) }
    }

    private fun navigateTo(destination: StartNavigationDestination) {
        navControllerPopBackStackInclusive()
        when (destination) {
            StartNavigationDestination.NavigateToLoginScreen -> navigateToLoginScreens()
            StartNavigationDestination.NavigateToMainScreen -> navigateToMainScreens()
            StartNavigationDestination.NavigateToAdminScreen -> Unit
            StartNavigationDestination.NavigateToAccountHasDeletedScreen -> Unit
        }
    }

    private fun navigateToLoginScreens() =
        findNavController()
            .navigate(R.id.login_navigation,
                bundleOf(),
                createNavOptionsWithAnimations())


    private fun navigateToMainScreens() =
        findNavController()
            .navigate(R.id.main_bottom,
                bundleOf(),
                createNavOptionsWithAnimations())


    private fun createNavOptionsWithAnimations() =
        NavOptions
            .Builder()
            .setEnterAnim(com.example.ui_core.R.anim.slide_up)
            .setExitAnim(com.example.ui_core.R.anim.slide_down)
            .setPopEnterAnim(com.example.ui_core.R.anim.slide_up)
            .setPopExitAnim(com.example.ui_core.R.anim.slide_down).build()


    private fun setProgressBarVisible(isVisible: Boolean) {
        binding().progressBar.isVisible = isVisible
    }


    private fun navControllerPopBackStackInclusive() =
        findNavController().popBackStack(R.id.splash_navigation, false)

}