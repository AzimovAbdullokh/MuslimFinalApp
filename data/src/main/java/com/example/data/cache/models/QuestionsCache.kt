package com.example.data.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


const val QUESTIONS_TABLE_NAME = "questions_table"

@Entity(tableName = QUESTIONS_TABLE_NAME)
class QuestionsCache(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "question") val question: String,
    @ColumnInfo(name = "answer") val answer: String,
    @ColumnInfo(name = "testCategory") val testCategory: String,
    @ColumnInfo(name = "a") val a: String,
    @ColumnInfo(name = "b") val b: String,
    @ColumnInfo(name = "c") val c: String,
    @ColumnInfo(name = "d") val d: String,
)