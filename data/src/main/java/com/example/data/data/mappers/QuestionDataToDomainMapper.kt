package com.example.data.data.mappers

import com.example.data.data.models.tests.TestQuestionData
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.tests.TestQuestionDomain
import javax.inject.Inject

class QuestionDataToDomainMapper @Inject constructor() :
    Mapper<TestQuestionData, TestQuestionDomain> {
    override fun map(from: TestQuestionData) = from.run {
        TestQuestionDomain(
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