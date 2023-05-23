package com.example.data.cloud.source.user

import com.example.data.base.ResponseHandler
import com.example.data.cloud.models.users.SessionTokenCloud
import com.example.data.cloud.service.UserService
import com.example.data.data.ResourceProvider
import javax.inject.Inject

class UsersCloudDataSourceImpl @Inject constructor(
    private val service: UserService,
    private val responseHandler: ResponseHandler,
) : UsersCloudDataSource {

    override suspend fun addSessionToken(id: String, sessionToken: String) = responseHandler.safeApiCall {
        service.addSessionToken(
            id = id,
            userSessionToken = SessionTokenCloud(sessionToken = sessionToken),
            sessionToken = sessionToken
        )
    }

}