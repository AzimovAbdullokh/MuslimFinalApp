package com.example.sign_in.repository

interface SignInModuleRepository {

   suspend fun signIn(email: String, password: String)
}