package com.example.muslimfinalapp.app.glue.audio_screen.gluing_repository


import com.example.alarms.domain.models.readers.ReadersFeatureModel
import com.example.alarms.domain.repository.QuranReadersFeatureRepository
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.readers.ReaderDomain
import com.example.domain.domain.domain.repositories.QuranReadersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AdapterQuranReadersAudioFeatureRepository @Inject constructor(
    private val quranReadersRepository: QuranReadersRepository,
    private val readerDomainToFeatureModelMapper: Mapper<ReaderDomain, ReadersFeatureModel>
): QuranReadersFeatureRepository {

    override fun fetchAllReaders(id: String): Flow<List<ReadersFeatureModel>>  =
        quranReadersRepository.fetchAllReaders(id = id).map {
            reader -> reader.map(readerDomainToFeatureModelMapper::map)
        }
}