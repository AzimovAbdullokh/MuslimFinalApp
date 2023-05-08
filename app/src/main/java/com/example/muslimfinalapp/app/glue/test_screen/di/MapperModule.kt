package com.example.muslimfinalapp.app.glue.test_screen.di

import com.example.common_api.Mapper
import com.example.domain.domain.domain.models.categories.CategoryDomain
import com.example.muslimfinalapp.app.glue.test_screen.mappers.CategoryDomainToFeatureModelMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import test_screen.test_category_screen.domain.models.CategoryFeatureDomain
import test_screen.test_category_screen.presentation.mappers.TestCategoryFeatureDomainToUiMapper
import test_screen.test_category_screen.presentation.mappers.TestItemsFilteredMapper
import test_screen.test_category_screen.presentation.mappers.TestItemsFilteredMapperImpl
import test_screen.test_category_screen.presentation.models.CategoryFeatureUi

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    @Binds
    abstract fun bindTestItemsFilteredMapper(
        impl: TestItemsFilteredMapperImpl,
    ): TestItemsFilteredMapper

    @Binds
    abstract fun bindTestCategoryFeatureDomainToUiMapper(
        impl: TestCategoryFeatureDomainToUiMapper,
    ): Mapper<CategoryFeatureDomain, CategoryFeatureUi>

    @Binds
    abstract fun bindCategoryDomainToFeatureModelMapper(
        impl: CategoryDomainToFeatureModelMapper,
    ): Mapper<CategoryDomain, CategoryFeatureDomain>
}