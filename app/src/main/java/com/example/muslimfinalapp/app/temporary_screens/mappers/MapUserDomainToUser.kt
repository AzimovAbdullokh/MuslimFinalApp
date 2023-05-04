package com.example.muslimfinalapp.app.temporary_screens.mappers

import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.users.UserDomain
import com.example.muslimfinalapp.app.temporary_screens.models.UserFeatures
import com.example.muslimfinalapp.app.temporary_screens.models.UserFeaturesImage
import com.example.muslimfinalapp.app.temporary_screens.models.UserType
import javax.inject.Inject

class MapUserDomainToUser @Inject constructor() : Mapper<UserDomain, UserFeatures> {
    override fun map(from: UserDomain): UserFeatures = from.run {
        if (from == UserDomain.unknown()) UserFeatures.unknown()
        UserFeatures(
            image = UserFeaturesImage(
                name = image.name,
                url = image.url,
                type = image.type
            ),
            objectId = objectId,
            userLogin = userLogin,
            userPassword = userPassword,
            lastName = lastName,
            firstName = firstName,
            userEmail = userEmail,
            sessionToken = sessionToken,
            age = age,
            userType = userType(userType),
        )
    }

    private fun userType(userType: String): UserType =
        when (userType) {
            "admin" -> UserType.admin
            "user" -> UserType.user
            else -> UserType.unknown
        }
}