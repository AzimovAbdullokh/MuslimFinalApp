package com.example.sign_up.ui

import com.example.common_api.DispatchersProvider
import com.example.common_api.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FragmentSignUpViewModel @Inject constructor(
//    private val loginRepository: LoginRepository,
    private val dispatchersProvider: DispatchersProvider,
//    private val userSignUpUiToDomainMapper: Mapper<UserSignUp, UserSignUpDomain>,
) : BaseViewModel() {

//    private val _successSignInFlow = createMutableSharedFlowAsSingleLiveEvent<UserSignUp>()
//    val successSignInFlow get() = _successSignInFlow.asSharedFlow()
//
//    fun signUpUser(user: UserSignUp) {
//        viewModelScope.launchSafe(dispatcher = dispatchersProvider.io(),
//            safeAction = { loginRepository.signUp(user = userSignUpUiToDomainMapper.map(user)) },
//            onSuccess = { _successSignInFlow.tryEmit(user) },
//            onError = {})
//    }
}