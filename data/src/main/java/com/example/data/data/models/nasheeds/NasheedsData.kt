package com.example.data.data.models.nasheeds

import java.util.*

class NasheedsData(
    val id: String,
    val title: String,
    val createdAt: Date,
    val nasheedFile: NasheedFileData,
    val nasheedPoster: NasheedPosterData,
    val audioId: String,
)

data class NasheedFileData(
    var name: String,
    var url: String,

    )

data class NasheedPosterData(
    var name: String,
    var url: String,
)