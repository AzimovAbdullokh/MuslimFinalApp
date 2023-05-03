package com.example.alarms.domain.usecases

import com.example.alarms.domain.models.MainNasheedItems
import com.example.alarms.domain.repository.AudioNasheedFeatureRepository
import com.example.common_api.DispatchersProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FetchAllNasheedsUseCaseImpl @Inject constructor(
    private val dispatchersProvider: DispatchersProvider,
    nasheedFeatureRepository: AudioNasheedFeatureRepository,
) : FetchAllNasheedsUseCase {

    override fun invoke(): Flow<MainNasheedItems> = combine(
        nasheedFlow,
        nasheedFloww
    ) { nasheeds, nasheed ->
        MainNasheedItems(
            nasheeds = nasheeds
        )
    }.flowOn(dispatchersProvider.default())

    private val nasheedFlow =
        nasheedFeatureRepository.fetchAllAudioNasheeds("38").flowOn(dispatchersProvider.io())

    private val nasheedFloww =
        nasheedFeatureRepository.fetchAllAudioNasheeds("38").flowOn(dispatchersProvider.io())
}