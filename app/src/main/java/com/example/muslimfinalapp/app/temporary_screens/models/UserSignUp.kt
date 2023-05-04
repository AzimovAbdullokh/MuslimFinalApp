package com.example.muslimfinalapp.app.temporary_screens.models

import android.os.Parcelable
import com.example.domain.domain.domain.models.users.UserImageDomain
import com.example.domain.domain.domain.models.users.UserSignUpDomain
import kotlinx.parcelize.Parcelize


@Parcelize
data class UserSignUp(
    var userLogin: String = String(),
    var userPassword: String = String(),
    var lastName: String = String(),
    var firstName: String = String(),
    var userEmail: String = String(),
    var age: String = String(),
    var sessionToken: String = String(),
) : Parcelable {

    fun mapToUserSignUpDomain() = UserSignUpDomain(
        userLogin = userLogin,
        userPassword = userPassword,
        lastName = lastName,
        firstName = firstName,
        userEmail = userEmail,
        age = age,
        sessionToken = sessionToken,
    )

    fun mapToUser(
        id: String,
        sessionToken: String,
        image: UserImageDomain,
    ) = UserFeatures(
        userLogin = userLogin,
        userPassword = userPassword,
        lastName = lastName,
        firstName = firstName,
        userEmail = userEmail,
        age = age,
        objectId = id,
        image = image.toDto(),
        sessionToken = sessionToken,
    )

    fun UserImageDomain.toDto(): UserFeaturesImage = UserFeaturesImage(
        type = type,
        url = url,
        name = name
    )

}