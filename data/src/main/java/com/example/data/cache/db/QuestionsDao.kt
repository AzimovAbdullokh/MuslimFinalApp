package com.example.data.cache.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.cache.models.QuestionsCache
import kotlinx.coroutines.flow.Flow

@Dao
interface QuestionsDao {

    @Query("select * from QUESTIONS_TABLE")
    fun fetchAllQuestionsObservable(): Flow<MutableList<QuestionsCache>>

    @Query("select * from QUESTIONS_TABLE")
    suspend fun fetchAllQuestionsSingle(): MutableList<QuestionsCache>

    @Query("select * from QUESTIONS_TABLE where id == :questionId")
    suspend fun fetchQuestionFromId(questionId: String): QuestionsCache

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNewQuestion(question: QuestionsCache)

    @Query("DELETE FROM QUESTIONS_TABLE")
    fun clearTable()
}