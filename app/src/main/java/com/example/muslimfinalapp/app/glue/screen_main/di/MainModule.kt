package com.example.muslimfinalapp.app.glue.screen_main.di

import android.content.Context
import com.example.common_api.ResourceProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Provides
    fun provideResourceProvider(
        context: Context,
    ): ResourceProvider = ResourceProvider.Base(context = context)
}