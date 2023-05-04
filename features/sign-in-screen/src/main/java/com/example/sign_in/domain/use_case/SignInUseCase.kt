package com.example.sign_in.domain.use_case

import com.example.sign_in.domain.repository.SignInModuleRepository
import com.example.sign_in.exception.ValidateError

interface SignInUseCase {

    suspend operator fun invoke(
        email: String,
        password: String
    )
}

class SignInUseCaseImpl(
    private val repository: SignInModuleRepository
): SignInUseCase {
    override suspend fun invoke(email: String, password: String) {
        if (email.length < 4){
            throw ValidateError(message = "Напиши email нормально")
        }
        else if (password.length <8){
            throw ValidateError(message = "Напиши password нормально")
        }
        else{
            repository.signIn(email, password)
        }
    }

}