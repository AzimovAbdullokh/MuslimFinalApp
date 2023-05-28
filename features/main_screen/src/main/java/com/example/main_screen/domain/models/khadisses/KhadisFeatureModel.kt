package com.example.main_screen.domain.models.khadisses

import java.util.*

class KhadisFeatureModel(
    val id: String,
    val title: String,
    val createdAt: Date,
    val khadisId: String,
    val namazImage:NamazPosterFeatureModel,
    val khadisDescription: String,
    val khadisSubject: String,
)
class NamazPosterFeatureModel(
    var name: String,
    var type: String,
    var url: String,
)