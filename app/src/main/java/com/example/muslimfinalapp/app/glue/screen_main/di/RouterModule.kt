package com.example.muslimfinalapp.app.glue.screen_main.di

import com.example.main_screen.presentation.router.FragmentMainScreenRouter
import com.example.muslimfinalapp.app.glue.screen_main.router.FragmentMainScreenRouterImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RouterModule {

    @Binds
    abstract fun bindFragmentMainScreenRouter(
        impl:FragmentMainScreenRouterImpl
    ): FragmentMainScreenRouter
}