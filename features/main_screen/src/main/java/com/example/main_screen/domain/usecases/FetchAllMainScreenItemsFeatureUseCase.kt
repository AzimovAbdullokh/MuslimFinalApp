package com.example.main_screen.domain.usecases

import com.example.main_screen.domain.models.MainScreenFeatureModuleItems
import kotlinx.coroutines.flow.Flow

interface FetchAllMainScreenItemsFeatureUseCase {

    operator fun invoke(): Flow<MainScreenFeatureModuleItems>
}