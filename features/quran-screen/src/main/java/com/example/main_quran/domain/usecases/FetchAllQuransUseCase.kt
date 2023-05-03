package com.example.main_quran.domain.usecases

import com.example.main_quran.domain.models.MainQuranItems
import kotlinx.coroutines.flow.Flow

interface FetchAllQuransUseCase {

    operator fun invoke(): Flow<MainQuranItems>
}