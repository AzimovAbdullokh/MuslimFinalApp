package com.example.common_impl.di

import com.example.common_api.CheckInternetConnection
import com.example.common_api.DispatchersProviderInCommonApi
import com.example.common_impl.CheckInternetConnectionImpl
import com.example.common_impl.DispatchersProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CommonClassesModule {

    @Binds
    abstract fun bindCheckInternetConnection(
        impl: CheckInternetConnectionImpl
    ): CheckInternetConnection

    @Binds
    abstract fun bindDispatchersProvider(
        impl: DispatchersProviderImpl
    ): DispatchersProviderInCommonApi
}