package com.example.data.cloud.source.user

import com.example.data.base.BaseApiResponse
import com.example.data.cloud.models.users.SessionTokenCloud
import com.example.data.cloud.service.UserService
import com.example.data.data.ResourceProvider
import javax.inject.Inject

class UsersCloudDataSourceImpl @Inject constructor(
    private val service: UserService,
    resourceProvider: ResourceProvider,
) : UsersCloudDataSource, BaseApiResponse(resourceProvider = resourceProvider) {

    override suspend fun addSessionToken(id: String, sessionToken: String) = safeApiCalll {
        service.addSessionToken(
            id = id,
            userSessionToken = SessionTokenCloud(sessionToken = sessionToken),
            sessionToken = sessionToken
        )
    }

}