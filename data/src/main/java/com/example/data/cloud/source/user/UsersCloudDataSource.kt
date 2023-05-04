package com.example.data.cloud.source.user

import com.example.data.cloud.CloudDataRequestState

interface UsersCloudDataSource {

    suspend fun addSessionToken(id: String, sessionToken: String): CloudDataRequestState<Unit>


}