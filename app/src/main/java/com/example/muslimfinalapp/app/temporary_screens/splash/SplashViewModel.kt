package com.example.muslimfinalapp.app.temporary_screens.splash

import androidx.lifecycle.viewModelScope
import com.example.common_api.base.BaseViewModel
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.users.UserDomain
import com.example.domain.domain.domain.repositories.UserCacheRepository
import com.example.muslimfinalapp.app.temporary_screens.sign_up.models.UserFeatures
import com.example.muslimfinalapp.app.temporary_screens.sign_up.models.UserType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withTimeout
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val mapper: Mapper<UserDomain, UserFeatures>,
    userCacheRepository: UserCacheRepository,
) : BaseViewModel() {

    private val _isProgressBarVisibleFlow = createMutableSharedFlowAsSingleLiveEvent<Boolean>()
    val isProgressBarVisibleFlow get() = _isProgressBarVisibleFlow.asSharedFlow()

    private val currentUserFromCacheFlow = userCacheRepository.fetchCurrentUserFromCache()
        .flowOn(Dispatchers.IO)
        .map(mapper::map)
        .filterNotNull()
        .flowOn(Dispatchers.Default)
        .onEach(::handleCurrentUserFromCache)
        .stateIn(viewModelScope, SharingStarted.Lazily, null)

    init {
        currentUserFromCacheFlow.launchIn(viewModelScope)
    }

    private val _navigateToFlow =
        createMutableSharedFlowAsSingleLiveEvent<StartNavigationDestination>()
    val navigateToFlow get() = _navigateToFlow.asSharedFlow()


    private fun searchNavigateInUserType(userType: UserType) =
        navigateActions[userType] ?: StartNavigationDestination.NavigateToMainScreen

    private fun handleCurrentUserFromCache(
        user: UserFeatures,
    ) = launchInBackground {
        withTimeout(SPLASH_SCREEN_DEFAULT_DELAY_TIME) {
            delay(1000)
            _navigateToFlow.tryEmit(searchNavigateInUserType(user.userType))
        }
    }

    private val navigateActions: Map<UserType, StartNavigationDestination> by lazy {
        mapOf(
            UserType.unknown to StartNavigationDestination.NavigateToLoginScreen,
            UserType.admin to StartNavigationDestination.NavigateToAdminScreen,
            UserType.user to StartNavigationDestination.NavigateToMainScreen,
        )
    }

    private fun emitNavigateToFlow(destination: StartNavigationDestination) =
        _navigateToFlow.tryEmit(destination)

    private companion object {
        const val SPLASH_SCREEN_DEFAULT_DELAY_TIME = 3000L
    }
}