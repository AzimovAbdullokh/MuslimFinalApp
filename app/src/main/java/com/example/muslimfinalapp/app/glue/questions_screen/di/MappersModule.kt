package com.example.muslimfinalapp.app.glue.questions_screen.di

import com.example.common_api.Mapper
import com.example.domain.domain.domain.models.tests.TestQuestionDomain
import com.example.muslimfinalapp.app.glue.questions_screen.mappers.QuestionDomainToFeatureModelMapper
import com.example.questions_screen.domain.model.TestQuestionFeatureDomain
import com.example.questions_screen.presentation.mapper.QuestionFeatureDomainToUiMapper
import com.example.questions_screen.presentation.model.TestQuestionFeatureUi
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MappersModule {

    @Binds
    abstract fun bindQuestionDomainToFeatureModelMapper(
        impl: QuestionDomainToFeatureModelMapper,
    ): Mapper<TestQuestionDomain, TestQuestionFeatureDomain>

    @Binds
    abstract fun bindQuestionFeatureDomainToUiMapper(
        impl: QuestionFeatureDomainToUiMapper,
    ): Mapper<TestQuestionFeatureDomain, TestQuestionFeatureUi>
}