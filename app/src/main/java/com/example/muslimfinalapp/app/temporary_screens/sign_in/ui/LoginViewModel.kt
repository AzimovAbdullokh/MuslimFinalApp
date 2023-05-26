package com.example.muslimfinalapp.app.temporary_screens.sign_in.ui

import androidx.lifecycle.viewModelScope
import com.example.common_api.DispatchersProviderInCommonApi
import com.example.common_api.base.BaseViewModel
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.users.UserDomain
import com.example.domain.domain.domain.repositories.LoginRepository
import com.example.muslimfinalapp.app.temporary_screens.sign_up.models.UserFeatures
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

//
//class LoginViewModel(
//    private val signInUseCase: SignInUseCase,
//) : ViewModel() {
//
//
//    fun signIn(email: String, password: String) = viewModelScope.launch {
//        kotlin.runCatching {
//            signInUseCase.invoke(email, password)
//        }.onSuccess {
//
//        }.onFailure(::handleError)
//    }
//
//    private fun handleError(error: Throwable) {
//        when (error) {
//            is ValidateError -> {
//                showToast(error.errorMessage)
//            }
//        }
//    }
//
//    private fun showToast(message: String) {}
//
//}


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: LoginRepository,
    private val dispatchersProvider: DispatchersProviderInCommonApi,
    private val mapper: Mapper<UserDomain, UserFeatures>,
) : BaseViewModel() {

    private val _successSignInFlow = createMutableSharedFlowAsSingleLiveEvent<UserFeatures>()
    val successSignInFlow get() = _successSignInFlow.asSharedFlow()

    fun signInWithEmailUseCase(email: String, password: String) {
        viewModelScope.launchSafe(
            dispatcher = dispatchersProvider.io(),
            safeAction = { repository.signIn(email, password) },
            onSuccess = { _successSignInFlow.tryEmit(mapper.map(it)) },
            onError = { "Error" }
        )
    }
//
//    private fun handleError(error: Throwable) {
//        when (error) {
//            is ValidateError -> {
//                showToast(error.errorMessage)
//            }
//        }
//    }
//

}