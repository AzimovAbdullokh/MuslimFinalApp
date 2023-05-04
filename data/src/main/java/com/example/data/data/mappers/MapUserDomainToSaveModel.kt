package com.example.data.data.mappers

import com.example.data.data.models.users.UserSaveModel
import com.example.data.data.models.users.UserSaveModelImage
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.users.UserDomain
import javax.inject.Inject

class MapUserDomainToSaveModel @Inject constructor() : Mapper<UserDomain, UserSaveModel> {
    override fun map(from: UserDomain): UserSaveModel = from.run {
        UserSaveModel(
            image = UserSaveModelImage(name = image.name, type = image.type, url = image.url),
            objectId = objectId,
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