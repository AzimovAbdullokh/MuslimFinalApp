package com.example.sign_in.domain.repository

import com.example.sign_in.domain.models.UserFeaturesDomain

interface SignInModuleRepository {

    suspend fun signIn(email: String, password: String): UserFeaturesDomain
}