package com.example.sign_in.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sign_in.SignInUseCase
import com.example.sign_in.ValidateError
import kotlinx.coroutines.launch

class LoginViewModel(
    private val signInUseCase: SignInUseCase,
) : ViewModel() {

    fun signIn(email: String, password: String) = viewModelScope.launch {
        kotlin.runCatching {
            signInUseCase.invoke(email, password)
        }.onSuccess {

        }.onFailure(::handleError)
    }

    private fun handleError(error: Throwable) {
        when (error) {
            is ValidateError -> {
                showToast(error.errorMessage)
            }
        }
    }

    private fun showToast(message: String) {}

}