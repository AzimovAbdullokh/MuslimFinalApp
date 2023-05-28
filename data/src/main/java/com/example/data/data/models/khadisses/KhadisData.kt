package com.example.data.data.models.khadisses

import java.util.*

data class KhadisData(
    val id: String,
    val title: String,
    val createdAt: Date,
    val khadisId: String,
    val khadisDescription: String,
    val khadisSubject: String,
    val namazImage: NamazPosterData,

    )

data class NamazPosterData(
    var name: String,
    var type: String,
    var url: String,
)