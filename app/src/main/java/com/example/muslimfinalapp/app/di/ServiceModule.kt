package com.example.muslimfinalapp.app.di

import com.example.data.cloud.service.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun provideUserService(retrofit: Retrofit): UserService =
        retrofit.create(UserService::class.java)

    @Provides
    @Singleton
    fun provideNasheedsService(retrofit: Retrofit): NasheedsService =
        retrofit.create(NasheedsService::class.java)

    @Provides
    @Singleton
    fun provideKhadisService(retrofit: Retrofit): KhadisService =
        retrofit.create(KhadisService::class.java)

    @Provides
    @Singleton
    fun provideLoginService(retrofit: Retrofit): LoginService =
        retrofit.create(LoginService::class.java)

    @Provides
    @Singleton
    fun provideBooksService(retrofit: Retrofit): BookService =
        retrofit.create(BookService::class.java)

    @Provides
    @Singleton
    fun provideCategoryService(retrofit: Retrofit): CategoryService =
        retrofit.create(CategoryService::class.java)

    @Provides
    @Singleton
    fun provideReadersService(retrofit: Retrofit): ReadersService =
        retrofit.create(ReadersService::class.java)

    @Provides
    @Singleton
    fun provideSurahService(retrofit: Retrofit): QuranService =
        retrofit.create(QuranService::class.java)

}