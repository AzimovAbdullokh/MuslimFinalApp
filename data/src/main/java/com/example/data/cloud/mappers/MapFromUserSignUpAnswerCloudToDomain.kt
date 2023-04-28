package com.example.data.cloud.mappers

import com.example.data.cloud.models.users.UserSignUpAnswerCloud
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.users.UserImageDomain
import com.example.domain.domain.domain.models.users.UserSignUpAnswerDomain
import javax.inject.Inject

class MapFromUserSignUpAnswerCloudToDomain @Inject constructor(
) : Mapper<UserSignUpAnswerCloud, UserSignUpAnswerDomain> {
    override fun map(from: UserSignUpAnswerCloud) = from.run {
        UserSignUpAnswerDomain(objectId = objectId,
            createdAt = createdAt,
            image = UserImageDomain(name = image.name, type = image.type, url = image.url),
            sessionToken = sessionToken
        )
    }
}