package com.example.muslimfinalapp.app.di

import com.example.data.cache.mappers.*
import com.example.data.cache.models.*
import com.example.data.cloud.mappers.*
import com.example.data.cloud.models.books.BookCloud
import com.example.data.cloud.models.books.BookResponseCloud
import com.example.data.cloud.models.category.CategoryCloud
import com.example.data.cloud.models.khadisses.KhadisCloud
import com.example.data.cloud.models.names.NamesCloud
import com.example.data.cloud.models.nasheeds.NasheedsCloud
import com.example.data.cloud.models.readers.ReadersCloud
import com.example.data.cloud.models.surah.SurahCloud
import com.example.data.cloud.models.surah.SurahResponseCloud
import com.example.data.cloud.models.tests.TestQuestionCloud
import com.example.data.cloud.models.users.UserCloud
import com.example.data.cloud.models.users.UserSignUpAnswerCloud
import com.example.data.cloud.models.users.UserSignUpCloud
import com.example.data.data.mappers.*
import com.example.data.data.models.books.BookData
import com.example.data.data.models.category.CategoryData
import com.example.data.data.models.khadisses.KhadisData
import com.example.data.data.models.names.NamesData
import com.example.data.data.models.nasheeds.NasheedsData
import com.example.data.data.models.readers.ReadersData
import com.example.data.data.models.surah.SurahData
import com.example.data.data.models.tests.TestQuestionData
import com.example.data.data.models.users.UserSaveModel
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.books.BookDomain
import com.example.domain.domain.domain.models.categories.CategoryDomain
import com.example.domain.domain.domain.models.khadisses.KhadisDomain
import com.example.domain.domain.domain.models.names.NamesDomain
import com.example.domain.domain.domain.models.nasheeds.NasheedsDomain
import com.example.domain.domain.domain.models.readers.ReaderDomain
import com.example.domain.domain.domain.models.surah.SurahDomain
import com.example.domain.domain.domain.models.tests.TestQuestionDomain
import com.example.domain.domain.domain.models.users.UserDomain
import com.example.domain.domain.domain.models.users.UserSignUpAnswerDomain
import com.example.domain.domain.domain.models.users.UserSignUpDomain
import com.example.muslimfinalapp.app.temporary_screens.sign_up.mappers.MapUserDomainToUser
import com.example.muslimfinalapp.app.temporary_screens.sign_up.mappers.MapUserSignUpToDomain
import com.example.muslimfinalapp.app.temporary_screens.sign_up.mappers.MapUserToDomain
import com.example.muslimfinalapp.app.temporary_screens.sign_up.models.UserFeatures
import com.example.muslimfinalapp.app.temporary_screens.sign_up.models.UserSignUp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MappersBindModule {

    @Binds
    abstract fun bindNamesCloudToDataMapper(
        impl: NamesCloudToDataMapper,
    ): Mapper<NamesCloud, NamesData>

    @Binds
    abstract fun bindNamesDataToDomainMapper(
        impl: NamesDataToDomainMapper,
    ): Mapper<NamesData, NamesDomain>

    @Binds
    abstract fun bindNamesDataToCacheMapper(
        impl: NamesDataToCacheMapper,
    ): Mapper<NamesData, NamesCache>

    @Binds
    abstract fun bindNamesCacheToDataMapper(
        impl: NamesCacheToDataMapper,
    ): Mapper<NamesCache, NamesData>

    @Binds
    abstract fun bindQuestionDataToDomainMapper(
        impl: QuestionDataToDomainMapper,
    ): Mapper<TestQuestionData, TestQuestionDomain>

    @Binds
    abstract fun bindQuestionDataToCacheMapper(
        impl: QuestionDataToCacheMapper,
    ): Mapper<TestQuestionData, QuestionsCache>

    @Binds
    abstract fun bindQuestionCacheToDataMapper(
        impl: QuestionCacheToDataMapper,
    ): Mapper<QuestionsCache, TestQuestionData>

    @Binds
    abstract fun bindQuestionCloudToDataMapper(
        impl: QuestionCloudToDataMapper,
    ): Mapper<TestQuestionCloud, TestQuestionData>

    @Binds
    abstract fun bindMapUserSignUpToDomain(
        impl: MapUserSignUpToDomain,
    ): Mapper<UserSignUp, UserSignUpDomain>

    @Binds
    abstract fun bindMapUserToDomain(
        impl: MapUserToDomain,
    ): Mapper<UserFeatures, UserDomain>

    @Binds
    abstract fun bindMapUserDomainToSaveModel(
        impl: MapUserDomainToSaveModel,
    ): Mapper<UserDomain, UserSaveModel>

    @Binds
    abstract fun bindMapUserSaveToDomain(
        impl: MapUserSaveToDomain,
    ): Mapper<UserSaveModel, UserDomain>

    @Binds
    abstract fun bindMapUserDomainToUserFeatures(
        impl: MapUserDomainToUser,
    ): Mapper<UserDomain, UserFeatures>

    @Binds
    abstract fun bindMapperUserCloudToDomain(
        impl: MapFromUserCloudToDomain,
    ): Mapper<UserCloud, UserDomain>

    @Binds
    abstract fun bindMapperUserSignUpAnswerCloudToDomain(
        impl: MapFromUserSignUpAnswerCloudToDomain,
    ): Mapper<UserSignUpAnswerCloud, UserSignUpAnswerDomain>

    @Binds
    abstract fun bindMapperUserSignUpDomainToCloud(
        impl: MapFromUserSignupDomainToCloud,
    ): Mapper<UserSignUpDomain, UserSignUpCloud>

    @Binds
    abstract fun bindMapperFromNasheedsCloudToData(
        impl: MapFromNasheedsCloudToData,
    ): Mapper<NasheedsCloud, NasheedsData>

    @Binds
    abstract fun bindMapperFromNasheedsDataToDomain(
        impl: MapFromNasheedsDataToDomain,
    ): Mapper<NasheedsData, NasheedsDomain>

    @Binds
    abstract fun bindMapperFromAudioNasheedsCacheToData(
        impl: MapFromAudioNasheedsCacheToData,
    ): Mapper<AudioNasheedsCashe, NasheedsData>

    @Binds
    abstract fun bindMapperFromNasheedsDataToCache(
        impl: MapFromNasheedsDataToCache,
    ): Mapper<NasheedsData, AudioNasheedsCashe>

    @Binds
    abstract fun bindMapFromKhadisDataToDomain(
        impl: MapFromKhadisDataToDomain,
    ): Mapper<KhadisData, KhadisDomain>

    @Binds
    abstract fun bindMapperFromKhadisCloudtoData(
        impl: MapFromKhadisCloudtoData,
    ): Mapper<KhadisCloud, KhadisData>

    @Binds
    abstract fun bindMapperFromKhadisDataToCache(
        impl: MapFromKhadisDataToCache,
    ): Mapper<KhadisData, KhadissesCache>

    @Binds
    abstract fun bindMapperFromKhadisCacheToData(
        impl: MapFromKhadisCacheToData,
    ): Mapper<KhadissesCache, KhadisData>

    @Binds
    abstract fun bindMapFromBookDataToDomain(
        impl: MapFromBookDataToDomain,
    ): Mapper<BookData, BookDomain>

    @Binds
    abstract fun bindMapFromBookDataToCache(
        impl: MapFromBookDataToCache,
    ): Mapper<BookData, BookCache>

    @Binds
    abstract fun bindMapFromBookCacheToData(
        impl: MapFromBookCacheToData,
    ): Mapper<BookCache, BookData>

    @Binds
    abstract fun bindMapFromCategoryCloudToData(
        impl: MapFromCategoryCloudToData,
    ): Mapper<CategoryCloud, CategoryData>

    @Binds
    abstract fun bindCategoryCacheToDataMapper(
        impl: MapFromCategoryCacheToData,
    ): Mapper<CategoryCache, CategoryData>

    @Binds
    abstract fun bindCategoryDataToCacheMapper(
        impl: MapFromCategoryDataToCache,
    ): Mapper<CategoryData, CategoryCache>

    @Binds
    abstract fun bindMapFromCategoryDataToDomain(
        impl: MapFromCategoryDataToDomain,
    ): Mapper<CategoryData, CategoryDomain>

    @Binds
    abstract fun bindBookResponseToBookCloudMapper(
        impl: BookResponseToBookCloudMapper,
    ): Mapper<BookResponseCloud, BookCloud>

    @Binds
    abstract fun bindReadersCloudToDataMapper(
        impl: ReadersCloudToDataMapper,
    ): Mapper<ReadersCloud, ReadersData>

    @Binds
    abstract fun bindReadersDataToDomainMapper(
        impl: ReadersDataToDomainMapper,
    ): Mapper<ReadersData, ReaderDomain>

    @Binds
    abstract fun bindReadersCacheToDataMapper(
        impl: ReadersCacheToDataMapper,
    ): Mapper<ReadersCache, ReadersData>

    @Binds
    abstract fun bindReadersDataToCacheMapper(
        impl: ReadersDataToCacheMapper,
    ): Mapper<ReadersData, ReadersCache>

    @Binds
    abstract fun bindSurahResponseCloudToDataMapper(
        impl: SurahResponseCloudToDataMapper,
    ): Mapper<SurahResponseCloud, SurahCloud>

    @Binds
    abstract fun bindSurahDataToDomainMapper(
        impl: SurahDataToDomainMapper,
    ): Mapper<SurahData, SurahDomain>

    @Binds
    abstract fun bindSurahDataToCacheMapper(
        impl: SurahDataToCacheMapper,
    ): Mapper<SurahData, SurahCache>

    @Binds
    abstract fun bindSurahCacheToDataMapper(
        impl: SurahCacheToDataMapper,
    ): Mapper<SurahCache, SurahData>

}
