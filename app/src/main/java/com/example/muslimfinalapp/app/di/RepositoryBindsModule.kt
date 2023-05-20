package com.example.muslimfinalapp.app.di

import com.example.data.data.repository.books.BooksRepositoryImpl
import com.example.data.data.repository.categories.CategoryRepositoryImpl
import com.example.data.data.repository.khadisses.KhadisRepositoryImpl
import com.example.data.data.repository.nasheeds.AudioNasheedRepositoryImpl
import com.example.data.data.repository.readers.QuranReadersRepositoryImpl
import com.example.data.data.repository.surah.SurahRepositoryImpl
import com.example.data.data.repository.test.QuestionRepositoryImpl
import com.example.data.data.repository.user.LoginRepositoryImpl
import com.example.data.data.repository.user.UserCacheRepositoryImpl
import com.example.domain.domain.domain.repositories.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryBindsModule {

    @Binds
    abstract fun bindQuestionRepository(impl: QuestionRepositoryImpl): QuestionRepository

    @Binds
    abstract fun bindLoginRepository(impl: LoginRepositoryImpl): LoginRepository

    @Binds
    abstract fun bindUserCacheRepository(impl: UserCacheRepositoryImpl): UserCacheRepository

    @Binds
    abstract fun bindaudioNasheedRepository(impl: AudioNasheedRepositoryImpl): AudioNasheedRepository

    @Binds
    abstract fun bindKhadisRepository(impl: KhadisRepositoryImpl): KhadisRepository

    @Binds
    abstract fun bindBookRepository(impl: BooksRepositoryImpl): BookRepository

    @Binds
    abstract fun bindCategoryRepository(impl: CategoryRepositoryImpl): CategoryRepository

    @Binds
    abstract fun bindQuranReadersRepository(impl: QuranReadersRepositoryImpl): QuranReadersRepository

    @Binds
    abstract fun bindSurahRepository(impl: SurahRepositoryImpl): SurahRepository
}