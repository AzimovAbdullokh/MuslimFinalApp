package com.example.muslimfinalapp.app.di

import android.content.Context
import androidx.room.Room
import com.example.data.cache.db.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

const val APP_DATABASE_NAME = "application_database"

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        context: Context,
    ): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, APP_DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideAudioNasheedsDao(database: AppDatabase): AudioNasheedsDao = database.getNasheedsDao()

    @Provides
    @Singleton
    fun provideKhadissesDao(database: AppDatabase): KhadissesDao = database.getKhadissesDao()

    @Provides
    @Singleton
    fun provideBooksDao(database: AppDatabase): BookDao = database.getBooksDao()

    @Provides
    @Singleton
    fun provideCategoryDao(database: AppDatabase): CategoryDao = database.getCategoriesDao()

    @Provides
    @Singleton
    fun provideReadersDao(database: AppDatabase): ReaderDao = database.getReadersDao()

    @Provides
    @Singleton
    fun provideSurahDao(database: AppDatabase): SurahDao = database.getSurahDao()

    @Provides
    @Singleton
    fun provideQuestionDao(database: AppDatabase): QuestionsDao = database.getQuestionsDao()

    @Provides
    @Singleton
    fun provideNamesDao(database: AppDatabase): NamesDao = database.getNamesDao()
}