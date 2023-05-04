package com.example.data.cloud.mappers

import com.example.data.cloud.models.users.UserSignUpCloud
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.users.UserSignUpDomain
import javax.inject.Inject

class MapFromUserSignupDomainToCloud @Inject constructor() :
    Mapper<UserSignUpDomain, UserSignUpCloud> {
    override fun map(from: UserSignUpDomain) = from.run {
        UserSignUpCloud(
            userLogin = userLogin,
            userPassword = userPassword,
            firstName = firstName,
            lastName = lastName,
            age = age,
            userEmail = userEmail,
            sessionToken = sessionToken
        )
    }
}