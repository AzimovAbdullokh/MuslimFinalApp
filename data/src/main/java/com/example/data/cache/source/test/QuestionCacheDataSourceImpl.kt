package com.example.data.cache.source.test

import com.example.data.cache.db.QuestionsDao
import com.example.data.cache.models.QuestionsCache
import com.example.data.data.models.tests.TestQuestionData
import com.example.domain.domain.domain.DispatchersProvider
import com.example.domain.domain.domain.Mapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class QuestionCacheDataSourceImpl @Inject constructor(
    private val dao: QuestionsDao,
    private val dispatchersProvider: DispatchersProvider,
    private val questionCacheToDataMapper: Mapper<QuestionsCache, TestQuestionData>,
    private val questionDataToCacheMapper: Mapper<TestQuestionData, QuestionsCache>,
) : QuestionCacheDataSource {

    override fun fetchAllQuestionsFromCacheObservable(): Flow<List<TestQuestionData>> =
        dao.fetchAllQuestionsObservable()
            .flowOn(dispatchersProvider.io())
            .map { questions -> questions.map(questionCacheToDataMapper::map) }
            .flowOn(dispatchersProvider.default())

    override suspend fun fetchAllQuestionsFromCacheSingle(): List<TestQuestionData> {
        val cachedQuestionList = dao.fetchAllQuestionsSingle()
        return cachedQuestionList.map(questionCacheToDataMapper::map)
    }

    override suspend fun addNewQuestionToCache(question: TestQuestionData) {
        dao.addNewQuestion(questionDataToCacheMapper.map(question))
    }

    override suspend fun fetchQuestionFromId(questionId: String): TestQuestionData =
        questionCacheToDataMapper.map(dao.fetchQuestionFromId(questionId = questionId))

    override suspend fun clearTable() {
        dao.clearTable()
    }
}