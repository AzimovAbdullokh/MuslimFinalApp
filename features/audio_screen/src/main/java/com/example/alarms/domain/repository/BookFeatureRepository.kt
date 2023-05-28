package com.example.alarms.domain.repository

import com.example.alarms.domain.models.books.BookFeatureModel
import kotlinx.coroutines.flow.Flow

interface BookFeatureRepository{

    fun fetchAllBooks(): Flow<List<BookFeatureModel>>
}