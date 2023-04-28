package com.example.muslimfinalapp.app.glue.screen_main.gluing_repositories

import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.readers.ReaderDomain
import com.example.domain.domain.domain.repositories.QuranReadersRepository
import com.example.main_screen.domain.models.readers.ReadersFeatureModel
import com.example.main_screen.domain.repository.QuranReadersFeatureRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AdapterQuranReadersFeatureRepository @Inject constructor(
    private val quranReadersRepository: QuranReadersRepository,
    private val readerDomainToFeatureModelMapper:Mapper<ReaderDomain, ReadersFeatureModel>
):QuranReadersFeatureRepository {

    override fun fetchAllReaders(id: String): Flow<List<ReadersFeatureModel>>  =
        quranReadersRepository.fetchAllReaders(id = id).map {
            reader -> reader.map(readerDomainToFeatureModelMapper::map)
        }

    override fun fetchAllReadersFromCache(): Flow<List<ReadersFeatureModel>>  =
        quranReadersRepository.fetchAllReadersFromCache().map {
            readers -> readers.map(readerDomainToFeatureModelMapper::map)
        }

    override suspend fun fetchReadersFromCache(readerId: String): ReadersFeatureModel {
        val reader = quranReadersRepository.fetchReadersFromCache(readerId = readerId)
        return readerDomainToFeatureModelMapper.map(reader)
    }

    override suspend fun clearTable() {
        quranReadersRepository.clearTable()
    }
}