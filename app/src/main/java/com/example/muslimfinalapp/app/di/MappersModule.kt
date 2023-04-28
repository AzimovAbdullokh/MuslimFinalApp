package com.example.muslimfinalapp.app.di

import com.example.data.cloud.mappers.BookCloudDataMapper
import com.example.data.cloud.mappers.BookCloudDataMapperImpl
import com.example.data.cloud.mappers.SurahCloudDataMapper
import com.example.data.cloud.mappers.SurahCloudDataMapperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MappersModule {

    @Provides
    fun provideBookCloudDataMapper(): BookCloudDataMapper = BookCloudDataMapperImpl()

    @Provides
    fun provideSurahCloudDataMapper(): SurahCloudDataMapper = SurahCloudDataMapperImpl()

}