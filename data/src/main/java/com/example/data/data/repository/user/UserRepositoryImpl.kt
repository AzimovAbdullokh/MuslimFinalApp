package com.example.data.data.repository.user

import com.example.data.cloud.source.user.UsersCloudDataSource
import com.example.data.data.repository.BaseRepository
import com.example.domain.domain.domain.repositories.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val cloudDataSource: UsersCloudDataSource,
) : UserRepository, BaseRepository {


    override suspend fun addSessionToken(id: String, sessionToken: String) = renderResultToUnit(
        result = cloudDataSource.addSessionToken(id = id, sessionToken = sessionToken)
    )

    override suspend fun clearUsersCache() {
//        cacheDataSource.clearUsersCache()
    }

}