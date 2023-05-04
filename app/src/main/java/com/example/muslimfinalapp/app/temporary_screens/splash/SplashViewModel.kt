package com.example.muslimfinalapp.app.temporary_screens.splash

import androidx.lifecycle.viewModelScope
import com.example.common_api.base.BaseViewModel
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.users.UserDomain
import com.example.domain.domain.domain.repositories.UserCacheRepository
import com.example.muslimfinalapp.app.temporary_screens.models.UserFeatures
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withTimeout
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
//    fetchInternetConnectedStatus: FetchInternetConnectedStatus,
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
//
//    private val isNetworkConnectedFlow = fetchInternetConnectedStatus()
//        .flowOn(Dispatchers.IO)
//        .shareIn(viewModelScope, SharingStarted.Lazily, 1)

    private fun handleError(error: Throwable) {
//        currentUserFromCacheFlow.value?.apply {
//            _navigateToFlow.tryEmit(searchNavigateInUserType(userType))
//        }
    }


    private fun searchNavigateInUserType() = StartNavigationDestination.NavigateToLoginScreen

    private fun handleCurrentUserFromCache(user: UserFeatures) = launchInBackground {
        withTimeout(SPLASH_SCREEN_DEFAULT_DELAY_TIME) {
            delay(1000)
            _navigateToFlow.tryEmit(searchNavigateInUserType())
//            when (user.userType) {
//                UserType.unknown -> {
//                    delay(SPLASH_SCREEN_DEFAULT_DELAY_TIME)
//                    emitNavigateToFlow(StartNavigationDestination.NavigateToLoginScreen)
//                }
//                UserType.admin -> {
//                    delay(SPLASH_SCREEN_DEFAULT_DELAY_TIME)
//                    emitNavigateToFlow(StartNavigationDestination.NavigateToAdminScreen)
//                }
//                else -> {
//                    fetchCurrentUserFromCloud(user.sessionToken)
//                }
//            }
        }
    }

    private fun emitNavigateToFlow(destination: StartNavigationDestination) {
        _navigateToFlow.tryEmit(destination)
    }

    private fun showProgressBar() {
        _isProgressBarVisibleFlow.tryEmit(true)
    }

    private companion object {
        const val SPLASH_SCREEN_DEFAULT_DELAY_TIME = 3000L
    }
}