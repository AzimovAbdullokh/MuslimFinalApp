package com.example.data.cache.mappers

import com.example.data.cache.models.QuestionsCache
import com.example.data.data.models.tests.TestQuestionData
import com.example.domain.domain.domain.Mapper
import javax.inject.Inject

class QuestionCacheToDataMapper @Inject constructor() : Mapper<QuestionsCache, TestQuestionData> {
    override fun map(from: QuestionsCache) = from.run {
        TestQuestionData(
            question = question,
            id = id,
            a = a,
            b = b,
            c = c,
            d = d,
            answer = answer,
            testCategory = testCategory,
        )
    }
}

class QuestionDataToCacheMapper @Inject constructor() : Mapper<TestQuestionData, QuestionsCache> {
    override fun map(from: TestQuestionData) = from.run {
        QuestionsCache(
            question = question,
            id = id,
            a = a,
            b = b,
            c = c,
            d = d,
            answer = answer,
            testCategory = testCategory,
        )
    }
}