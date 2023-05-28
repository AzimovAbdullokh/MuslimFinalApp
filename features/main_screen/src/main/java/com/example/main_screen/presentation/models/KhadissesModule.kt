package com.example.main_screen.presentation.models

import java.util.*

data class KhadissesFeatureUi(
    val id: String,
    val title: String,
    val createdAt: Date,
    val khadisId: String,
    val khadisDescription: String,
    val khadisSubject: String,
    val namzImage: NamazPosterUi,
)

class NamazPosterUi(
    var name: String,
    var type: String,
    var url: String,
)