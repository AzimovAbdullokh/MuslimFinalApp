package com.example.data.data.repository.test

import com.example.data.cache.source.test.QuestionCacheDataSource
import com.example.data.cloud.source.category.CategoryCloudDataSource
import com.example.data.data.models.tests.TestQuestionData
import com.example.domain.domain.domain.DispatchersProvider
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.tests.TestQuestionDomain
import com.example.domain.domain.domain.repositories.QuestionRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class QuestionRepositoryImpl @Inject constructor(
    private val cloudDataSource: CategoryCloudDataSource,
    private val cacheDataSource: QuestionCacheDataSource,
    private val dispatchersProvider: DispatchersProvider,
    private val questionDataToDomainMapper: Mapper<TestQuestionData, TestQuestionDomain>,
) : QuestionRepository {

    override fun fetchAllQuestions(): Flow<List<TestQuestionDomain>> =
        flow { emit(cacheDataSource.fetchAllQuestionsFromCacheSingle()) }
            .flatMapLatest { handleFetchCategoriesInCache(it) }
            .map { questions -> questions.map(questionDataToDomainMapper::map) }
            .flowOn(dispatchersProvider.default())


    private fun handleFetchCategoriesInCache(
        cachedQuestions: List<TestQuestionData>,
    ) = if (cachedQuestions.isEmpty()) cloudDataSource.fetchAllQuestionsFromCloud()
        .onEach { questions -> questions.forEach { cacheDataSource.addNewQuestionToCache(it) } }
    else cacheDataSource.fetchAllQuestionsFromCacheObservable()


    override suspend fun fetchQuestionsFromCache(questionId: String): TestQuestionDomain {
        return questionDataToDomainMapper.map(cacheDataSource.fetchQuestionFromId(questionId = questionId))
    }
}