package com.example.domain.domain.domain.models.users

import java.util.*

data class UserSignUpAnswerDomain(
    val objectId: String,
    val createdAt: Date,
    val image: UserImageDomain,
    val sessionToken: String,
)