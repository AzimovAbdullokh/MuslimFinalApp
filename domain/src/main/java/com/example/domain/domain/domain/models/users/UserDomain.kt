package com.example.domain.domain.domain.models.users

import java.util.*

class UserDomain(
    val objectId: String,
    var email: String,
    var lastName: String,
    var firstName: String,
    var age: String,
    var createAt: Date,
    var image: UserImageDomain = UserImageDomain.unknown(),
    var password: String? = null,
    var sessionToken: String,
)