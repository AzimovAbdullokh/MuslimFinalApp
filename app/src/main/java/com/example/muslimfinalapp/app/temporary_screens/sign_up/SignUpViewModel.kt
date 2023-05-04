package com.example.muslimfinalapp.app.temporary_screens.sign_up

import androidx.lifecycle.viewModelScope
import com.example.common_api.DispatchersProvider
import com.example.common_api.ResourceProvider
import com.example.common_api.base.BaseViewModel
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.users.UserDomain
import com.example.domain.domain.domain.models.users.UserSignUpAnswerDomain
import com.example.domain.domain.domain.models.users.UserSignUpDomain
import com.example.domain.domain.domain.repositories.LoginRepository
import com.example.domain.domain.domain.repositories.UserCacheRepository
import com.example.domain.domain.domain.repositories.UserRepository
import com.example.muslimfinalapp.app.temporary_screens.models.UserFeatures
import com.example.muslimfinalapp.app.temporary_screens.models.UserSignUp
import com.example.muslimfinalapp.app.temporary_screens.sign_in.ui.launchSafe
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject


@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val loginRepository: LoginRepository,
    private val userRepository: UserRepository,
    private val userCacheRepository: UserCacheRepository,
    private val resourceProvider: ResourceProvider,
    private val dispatchersProvider: DispatchersProvider,
    private val mapper: Mapper<UserFeatures, UserDomain>,
    private val mapperUserSignUp: Mapper<UserSignUp, UserSignUpDomain>,
) : BaseViewModel() {


    private val _isProgressBarVisibleFlow = createMutableSharedFlowAsSingleLiveEvent<Boolean>()
    val isProgressBarVisibleFlow get() = _isProgressBarVisibleFlow.asSharedFlow()

    private val _isProgressDialogVisibleFlow = createMutableSharedFlowAsSingleLiveEvent<Boolean>()
    val isProgressDialogVisibleFlow get() = _isProgressDialogVisibleFlow.asSharedFlow()

    private val _isErrorMessageVisibleFlow = createMutableSharedFlowAsSingleLiveEvent<Boolean>()
    val isErrorMessageVisibleFlow get() = _isErrorMessageVisibleFlow.asSharedFlow()

    private val _handleSignUpFlow = createMutableSharedFlowAsSingleLiveEvent<Unit>()
    val handleSignUpFlow get() = _handleSignUpFlow.asSharedFlow()

    private var currentUserFlow = MutableStateFlow(UserFeatures.unknown())
//
//    private val userSignUp = createMutableSharedFlowAsSingleLiveEvent<UserSignUp>()
//    val successSignInFlow get() = userSignUp.asSharedFlow()


    fun startSignUp(user: UserSignUp) {
        emitIsErrorMessageVisibleFlow(isVisible = false)
        signUpUser(user)
    }


    fun signUpUser(user: UserSignUp) {
        emitIsProgressDialogVisibleFlow(isVisible = true)
        viewModelScope.launchSafe(
            dispatcher = dispatchersProvider.io(),
            safeAction = { loginRepository.signUp(user = mapperUserSignUp.map(user)) },
            onSuccess = {
                emitIsProgressDialogVisibleFlow(isVisible = false)
                setAndMapToCurrentUser(it, user = user)
                startAddingSessionToken()
            },
            onError = {
                handleError(it)
                emitIsProgressDialogVisibleFlow(isVisible = false)
            }
        )
    }

    private fun startAddingSessionToken() {
        val user = currentUserFlow.value
        viewModelScope.launchSafe(
            dispatcher = dispatchersProvider.io(),
            safeAction = { userRepository.addSessionToken(user.objectId, user.sessionToken) },
            onError = ::handleError,
            onSuccess = { handleAddingSessionTokenResult() }
        )
    }

    private fun handleAddingSessionTokenResult() {
        saveNewCurrentUserToCache()
        _handleSignUpFlow.tryEmit(Unit)
    }

    private fun saveNewCurrentUserToCache() = launchInBackground {
        userCacheRepository.saveCurrentUserFromCache(mapper.map(currentUserFlow.value))
    }

    private fun handleError(exception: Throwable) {
        val errorMessage = resourceProvider.fetchIdErrorMessage(exception)
        emitToErrorMessageFlow(errorMessage)
    }

    private fun setAndMapToCurrentUser(requestAnswerDomain: UserSignUpAnswerDomain, user: UserSignUp) {
        val newUser = user.mapToUser(
            id = requestAnswerDomain.objectId,
            sessionToken = requestAnswerDomain.sessionToken,
            image = requestAnswerDomain.image
        )
        currentUserFlow.tryEmit(newUser)
    }

    private fun emitIsProgressDialogVisibleFlow(isVisible: Boolean) {
        _isProgressDialogVisibleFlow.tryEmit(isVisible)
    }

    private fun emitIsErrorMessageVisibleFlow(isVisible: Boolean) {
        _isErrorMessageVisibleFlow.tryEmit(isVisible)
    }
//
//    fun goSignUpToLoginFragment() =
//        navigate(SignUpFragmentDirections.actionSignUpFragmentToLoginFragment())

    fun goBack() = navigateBack()
}

