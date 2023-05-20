package com.example.data.cloud.mappers

import com.example.data.cloud.models.tests.TestQuestionCloud
import com.example.data.data.models.tests.TestQuestionData
import com.example.domain.domain.domain.Mapper
import javax.inject.Inject

class QuestionCloudToDataMapper @Inject constructor() :
    Mapper<TestQuestionCloud, TestQuestionData> {
    override fun map(from: TestQuestionCloud) = from.run {
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