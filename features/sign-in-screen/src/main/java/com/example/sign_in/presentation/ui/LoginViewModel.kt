package com.example.sign_in.presentation.ui

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
//
//
//@HiltViewModel
//class LoginViewModel @Inject constructor(
//    private val signInUseCase: SignInUseCase,
//    private val dispatchersProvider: DispatchersProvider,
//    private val mapper: Mapper<UserFeaturesDomain, UserFeatures>,
//) : BaseViewModel() {
//
//    private val _successSignInFlow = createMutableSharedFlowAsSingleLiveEvent<UserFeatures>()
//    val successSignInFlow get() = _successSignInFlow.asSharedFlow()
//
//    fun signInWithEmailUseCase(email: String, password: String) {
////        viewModelScope.launchSafe(
////            dispatcher = dispatchersProvider.io(),
////            safeAction = { signInUseCase.invoke(email = email, password = password) },
////            onSuccess = { _successSignInFlow.tryEmit(mapper.map(it)) },
////            onError = (::handleError)
////        )
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
//    private fun showToast(message: String) {
//
//    }
//
//}