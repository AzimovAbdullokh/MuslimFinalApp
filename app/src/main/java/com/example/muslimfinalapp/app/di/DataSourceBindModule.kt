package com.example.muslimfinalapp.app.di

import com.example.data.cache.source.books.BooksCacheDataSource
import com.example.data.cache.source.books.BooksCacheDataSourceImpl
import com.example.data.cache.source.categories.CategoriesCacheDataSource
import com.example.data.cache.source.categories.CategoriesCacheDataSourceImpl
import com.example.data.cache.source.khadisses.KhadissesCacheDataSource
import com.example.data.cache.source.khadisses.KhadissesCacheDataSourceImpl
import com.example.data.cache.source.nasheeds.AudioNasheedsCacheDataSource
import com.example.data.cache.source.nasheeds.AudioNasheedsCacheDataSourceImpl
import com.example.data.cache.source.readers.QuranReadersCacheDataSource
import com.example.data.cache.source.readers.QuranReadersCacheDataSourceImpl
import com.example.data.cache.source.surah.SurahCacheDataSource
import com.example.data.cache.source.surah.SurahCacheDataSourceImpl
import com.example.data.cloud.source.books.BooksCloudDataSource
import com.example.data.cloud.source.books.BooksCloudDataSourceImpl
import com.example.data.cloud.source.category.CategoryCloudDataSource
import com.example.data.cloud.source.category.CategoryCloudDataSourceImpl
import com.example.data.cloud.source.khadisses.KhadissesCloudDataSource
import com.example.data.cloud.source.khadisses.KhadissesCloudDataSourceImpl
import com.example.data.cloud.source.nasheeds.AudioNasheedCloudDataSource
import com.example.data.cloud.source.nasheeds.AudioNasheedCloudDataSourceImpl
import com.example.data.cloud.source.readers.QuranReadersCloudDataSource
import com.example.data.cloud.source.readers.QuranReadersCloudDataSourceImpl
import com.example.data.cloud.source.surah.SurahCloudDataSource
import com.example.data.cloud.source.surah.SurahCloudDataSourceImpl
import com.example.data.cloud.source.user.UsersCloudDataSource
import com.example.data.cloud.source.user.UsersCloudDataSourceImpl
import com.example.data.data.repository.user.UserRepositoryImpl
import com.example.domain.domain.domain.repositories.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceBindModule {

    @Binds
    abstract fun bindAudioNasheedCloudDataSource(
        impl: AudioNasheedCloudDataSourceImpl,
    ): AudioNasheedCloudDataSource

    @Binds
    abstract fun bindAudioNasheedCacheDataSource(
        impl: AudioNasheedsCacheDataSourceImpl,
    ): AudioNasheedsCacheDataSource


    @Binds
    abstract fun bindKhadissesCloudDataSource(
        impl: KhadissesCloudDataSourceImpl,
    ): KhadissesCloudDataSource

    @Binds
    abstract fun bindKhadissesCacheDataSource(
        impl: KhadissesCacheDataSourceImpl,
    ): KhadissesCacheDataSource


    @Binds
    abstract fun bindBookCloudDataSource(
        impl: BooksCloudDataSourceImpl,
    ): BooksCloudDataSource

    @Binds
    abstract fun bindBookCacheDataSource(
        impl: BooksCacheDataSourceImpl,
    ): BooksCacheDataSource


    @Binds
    abstract fun bindCategoryCloudDataSource(
        impl: CategoryCloudDataSourceImpl,
    ): CategoryCloudDataSource

    @Binds
    abstract fun bindCategoryCacheDataSource(
        impl: CategoriesCacheDataSourceImpl,
    ): CategoriesCacheDataSource

    @Binds
    abstract fun bindQuranReadersCloudDataSource(
        impl: QuranReadersCloudDataSourceImpl,
    ): QuranReadersCloudDataSource

    @Binds
    abstract fun bindQuranReadersCacheDataSource(
        impl: QuranReadersCacheDataSourceImpl,
    ): QuranReadersCacheDataSource

    @Binds
    abstract fun bindSurahCloudDataSource(
        impl: SurahCloudDataSourceImpl,
    ): SurahCloudDataSource

    @Binds
    abstract fun bindSurahCacheDataSource(
        impl: SurahCacheDataSourceImpl,
    ): SurahCacheDataSource

    @Binds
    abstract fun bindUsersCloudDataSource(
        impl: UsersCloudDataSourceImpl,
    ): UsersCloudDataSource

    @Binds
    abstract fun bindUserRepository(
        impl: UserRepositoryImpl,
    ): UserRepository

}