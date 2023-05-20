package com.example.muslimfinalapp.app.glue.test_screen.di

import com.example.muslimfinalapp.app.glue.test_screen.router.TestCategoryScreenRouterImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import test_screen.test_category_screen.presentation.router.TestCategoryScreenRouter

@Module
@InstallIn(SingletonComponent::class)
abstract class RouterModule {

    @Binds
    abstract fun bindTestCategoryScreenRouter(
        impl: TestCategoryScreenRouterImpl
    ):TestCategoryScreenRouter
}