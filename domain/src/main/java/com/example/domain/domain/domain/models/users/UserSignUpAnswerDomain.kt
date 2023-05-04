package com.example.domain.domain.domain.models.users

import java.util.*

data class UserSignUpAnswerDomain(
    val objectId: String,
    val sessionToken: String,
    val image: UserImageDomain,
    val createdAt: Date,
) {
    companion object {

        fun unknown() = UserSignUpAnswerDomain(
            objectId = String(),
            sessionToken = String(),
            createdAt = Date(),
            image = UserImageDomain.unknown(),
        )
    }
}
