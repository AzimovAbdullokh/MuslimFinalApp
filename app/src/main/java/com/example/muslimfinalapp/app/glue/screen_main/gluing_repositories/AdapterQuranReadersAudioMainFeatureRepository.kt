package com.example.muslimfinalapp.app.glue.screen_main.gluing_repositories


import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.readers.ReaderDomain
import com.example.domain.domain.domain.repositories.QuranReadersRepository
import com.example.main_screen.domain.models.readers.ReadersFeatureMainModel
import com.example.main_screen.domain.repository.QuranReadersMainFeatureRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AdapterQuranReadersAudioMainFeatureRepository @Inject constructor(
    private val quranReadersRepository: QuranReadersRepository,
    private val readerDomainToFeatureModelMapper: Mapper<ReaderDomain, ReadersFeatureMainModel>
): QuranReadersMainFeatureRepository {

    override fun fetchAllReaders(id: String): Flow<List<ReadersFeatureMainModel>>  =
        quranReadersRepository.fetchAllReaders(id = id).map {
            reader -> reader.map(readerDomainToFeatureModelMapper::map)
        }

    override fun fetchAllReadersFromCache(): Flow<List<ReadersFeatureMainModel>>  =
        quranReadersRepository.fetchAllReadersFromCache().map {
            readers -> readers.map(readerDomainToFeatureModelMapper::map)
        }

    override suspend fun fetchReadersFromCache(readerId: String): ReadersFeatureMainModel {
        val reader = quranReadersRepository.fetchReadersFromCache(readerId = readerId)
        return readerDomainToFeatureModelMapper.map(reader)
    }

    override suspend fun clearTable() {
        quranReadersRepository.clearTable()
    }
}