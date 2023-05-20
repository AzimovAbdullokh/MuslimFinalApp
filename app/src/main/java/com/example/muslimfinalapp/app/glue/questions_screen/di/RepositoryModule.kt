package com.example.muslimfinalapp.app.glue.questions_screen.di

import com.example.muslimfinalapp.app.glue.questions_screen.gluing.AdapterQuestionFeatureRepository
import com.example.questions_screen.domain.repository.QuestionFeatureRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindAdapterQuestionFeatureRepository(
        impl: AdapterQuestionFeatureRepository,
    ): QuestionFeatureRepository
}