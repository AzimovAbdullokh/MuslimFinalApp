package com.example.domain.domain.domain.models.khadisses

import java.util.*

data class KhadisDomain(
    val id: String,
    val title: String,
    val createdAt: Date,
    val khadisId: String,
    val khadisDescription: String,
    val khadisSubject: String,
    val namazImage:NamazPosterDomain
)
class NamazPosterDomain(
    var name: String,
    var type: String,
    var url: String,
)