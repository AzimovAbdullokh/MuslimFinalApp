package com.example.domain.domain.domain.models.users

class UserImageDomain(
    var name: String,
    var type: String,
    var url: String,
) {
    companion object {
        fun unknown() = UserImageDomain(
            name = String(),
            type = String(),
            url = String(),
        )
    }
}
