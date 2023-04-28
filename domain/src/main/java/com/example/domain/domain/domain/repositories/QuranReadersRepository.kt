package com.example.domain.domain.domain.repositories

import com.example.domain.domain.domain.models.readers.ReaderDomain
import kotlinx.coroutines.flow.Flow

interface QuranReadersRepository {

    fun fetchAllReaders(id: String): Flow<List<ReaderDomain>>

    fun fetchAllReadersFromCache(): Flow<List<ReaderDomain>>

    suspend fun fetchReadersFromCache(readerId: String): ReaderDomain

    suspend fun clearTable()
}