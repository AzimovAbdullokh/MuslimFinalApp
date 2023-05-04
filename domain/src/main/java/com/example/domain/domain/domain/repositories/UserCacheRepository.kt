package com.example.domain.domain.domain.repositories

import com.example.domain.domain.domain.models.users.UserDomain
import kotlinx.coroutines.flow.Flow

interface UserCacheRepository {

    fun fetchCurrentUserFromCache(): Flow<UserDomain>

    suspend fun saveCurrentUserFromCache(newUser: UserDomain): Boolean

    suspend fun clear()


}