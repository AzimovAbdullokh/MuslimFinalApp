package com.example.domain.domain.domain.repositories

import com.example.domain.domain.domain.RequestState
import com.example.domain.domain.domain.models.users.UserDomain
import com.example.domain.domain.domain.models.users.UserSignUpAnswerDomain
import com.example.domain.domain.domain.models.users.UserSignUpDomain

interface LoginRepository {

    suspend fun signIn(email: String, password: String): RequestState<UserDomain>

    suspend fun signUp(user: UserSignUpDomain): RequestState<UserSignUpAnswerDomain>

}