package com.example.muslimfinalapp.app.temporary_screens.mappers

import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.users.UserDomain
import com.example.domain.domain.domain.models.users.UserImageDomain
import com.example.muslimfinalapp.app.temporary_screens.models.UserFeatures
import javax.inject.Inject

class MapUserToDomain @Inject constructor() : Mapper<UserFeatures, UserDomain> {
    override fun map(from: UserFeatures) = from.run {
        if (from == UserFeatures.unknown()) UserDomain.unknown()
        UserDomain(
            image = image?.let { UserImageDomain(name = it.name, url = it.url, type = it.type) }
                ?: UserImageDomain.unknown(),
            objectId = objectId,
            userLogin = userLogin,
            userPassword = userPassword,
            lastName = lastName,
            firstName = firstName,
            userEmail = userEmail,
            sessionToken = sessionToken,
            age = age,
        )
    }
}