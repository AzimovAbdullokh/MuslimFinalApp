package com.example.alarms.domain.usecases

import com.example.alarms.domain.models.MainNasheedItems
import kotlinx.coroutines.flow.Flow

interface FetchAllNasheedsUseCase {

    operator fun invoke(): Flow<MainNasheedItems>
}