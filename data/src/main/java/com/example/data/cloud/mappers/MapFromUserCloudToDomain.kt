package com.example.data.cloud.mappers

import com.example.data.cloud.models.users.UserCloud
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.users.UserDomain
import com.example.domain.domain.domain.models.users.UserImageDomain
import javax.inject.Inject

class MapFromUserCloudToDomain @Inject constructor() : Mapper<UserCloud, UserDomain> {
    override fun map(from: UserCloud) = from.run {
        UserDomain(
            email = email,
            lastName = lastName,
            objectId = objectId,
            firstName = firstName,
            sessionToken = sessionToken ?: String(),
            image = UserImageDomain(name = image.name, type = image.type, url = image.url),
            age = age,
            createAt = createAt)
    }
}