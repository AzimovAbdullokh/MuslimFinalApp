package com.example.muslimfinalapp.app.di

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.example.data.base.ResponseHandler
import com.example.data.base.ResponseHandlerImpl
import com.example.data.data.ResourceProvider
import com.example.domain.domain.domain.DispatchersProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context)

    @Provides
    @Singleton
    fun provideDispatchersProvider():DispatchersProvider = DispatchersProvider.Base()

    @Provides
    @Singleton
    fun provideContext(@ApplicationContext context: Context): Context = context

    @Provides
    @Singleton
    fun provideResourceProvider(context: Context):ResourceProvider = ResourceProvider.Base(context = context)

    @Provides
    @Singleton
    fun provideResponseHandler(
        dispatchersProvider: DispatchersProvider
    ): ResponseHandler = ResponseHandlerImpl(
        dispatchersProvider = dispatchersProvider
    )
}