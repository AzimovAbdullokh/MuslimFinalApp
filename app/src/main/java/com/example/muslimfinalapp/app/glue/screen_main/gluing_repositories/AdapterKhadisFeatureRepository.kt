package com.example.muslimfinalapp.app.glue.screen_main.gluing_repositories

import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.khadisses.KhadisDomain
import com.example.domain.domain.domain.repositories.KhadisRepository
import com.example.main_screen.domain.models.khadisses.KhadisFeatureModel
import com.example.main_screen.domain.repository.KhadisFeatureRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AdapterKhadisFeatureRepository @Inject constructor(
    private val khadisRepository: KhadisRepository,
    private val khadisDomainToFeatureModelMapper: Mapper<KhadisDomain, KhadisFeatureModel>,
) : KhadisFeatureRepository {

    override fun fetchAllKhadisses(id: String): Flow<List<KhadisFeatureModel>> =
        khadisRepository.fetchAllKhadisses(id = id).map { khadis ->
            khadis.map(khadisDomainToFeatureModelMapper::map)
        }

    override fun fetchAllKhadissesFromCache(): Flow<List<KhadisFeatureModel>> =
        khadisRepository.fetchAllKhadissesFromCache().map { khadis ->
            khadis.map(khadisDomainToFeatureModelMapper::map)
        }

    override suspend fun fetcKhadissesFromCache(khadisId: String): KhadisFeatureModel {
        val khadis = khadisRepository.fetcKhadissesFromCache(khadisId = khadisId)
        return khadisDomainToFeatureModelMapper.map(khadis)
    }

    override suspend fun clearTable() {
        khadisRepository.clearTable()
    }
}