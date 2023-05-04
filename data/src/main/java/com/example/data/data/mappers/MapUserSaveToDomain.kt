package com.example.data.data.mappers

import com.example.data.data.models.users.UserSaveModel
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.users.UserDomain
import com.example.domain.domain.domain.models.users.UserImageDomain
import javax.inject.Inject

class MapUserSaveToDomain @Inject constructor() : Mapper<UserSaveModel, UserDomain> {
    override fun map(from: UserSaveModel): UserDomain = from.run {
        if (from == UserSaveModel.unknown()) {
            UserDomain.unknown()
        } else UserDomain(
            image = UserImageDomain(name = image.name, type = image.type, url = image.url),
            objectId = objectId,
            userLogin = userLogin,
            userPassword = userPassword,
            lastName = lastName,
            firstName = firstName,
            userEmail = userEmail,
            sessionToken = sessionToken,
            age = age,
            userType = userType
        )
    }
}