package com.example.muslimfinalapp.app.temporary_screens.mappers

import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.users.UserSignUpDomain
import com.example.muslimfinalapp.app.temporary_screens.models.UserSignUp
import javax.inject.Inject

class MapUserSignUpToDomain @Inject constructor() : Mapper<UserSignUp, UserSignUpDomain> {
    override fun map(from: UserSignUp) = from.run {
        UserSignUpDomain(
            userLogin = userLogin,
            userPassword = userPassword,
            lastName = lastName,
            firstName = firstName,
            userEmail = userEmail,
            sessionToken = sessionToken,
            age = age
        )
    }
}