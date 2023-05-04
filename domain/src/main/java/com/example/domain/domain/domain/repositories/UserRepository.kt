package com.example.domain.domain.domain.repositories

import com.example.domain.domain.domain.RequestState

interface UserRepository {
//    suspend fun updateUserParameters(
//        id: String,
//        user: UserUpdateDomain,
//        sessionToken: String,
//    ): RequestState<UpdateAnswerDomain>

    suspend fun addSessionToken(id: String, sessionToken: String): RequestState<Unit>

    suspend fun clearUsersCache()

}