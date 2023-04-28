package com.example.data.data.repository.user

import com.example.data.base.BaseApiResponse
import com.example.data.cloud.models.users.UserCloud
import com.example.data.cloud.models.users.UserSignUpAnswerCloud
import com.example.data.cloud.models.users.UserSignUpCloud
import com.example.data.cloud.service.LoginService
import com.example.data.data.ResourceProvider
import com.example.data.data.repository.BaseRepository
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.users.UserSignUpAnswerDomain
import com.example.domain.domain.domain.models.users.UserDomain
import com.example.domain.domain.domain.models.users.UserSignUpDomain
import com.example.domain.domain.domain.repositories.LoginRepository
import com.example.domain.domain.domain.RequestState
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val service: LoginService,
    private val mapUserCloudToDomain: Mapper<UserCloud, UserDomain>,
    private val mapUserDomainToCloud: Mapper<UserSignUpDomain, UserSignUpCloud>,
    private val mapUserResponseCloudToDomain: Mapper<UserSignUpAnswerCloud, UserSignUpAnswerDomain>,
    resourceProvider: ResourceProvider,
) : LoginRepository, BaseApiResponse(resourceProvider = resourceProvider), BaseRepository {

    override suspend fun signIn(email: String, password: String): RequestState<UserDomain> {
        val result = safeApiMapperCalll(mapper = mapUserCloudToDomain) {
            service.signIn(username = email, password = password)
        }
        return renderResult(
            result = result,
        )
    }

    override suspend fun signUp(user: UserSignUpDomain): RequestState<UserSignUpAnswerDomain> {
        val result = safeApiCalll { service.signUp(user = mapUserDomainToCloud.map(user)) }
        return renderResult(result = result).map(mapUserResponseCloudToDomain)
    }

}