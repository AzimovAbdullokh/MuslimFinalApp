package com.example.audioservice.service_player.domain.models

import java.util.*

class NasheedsFeatureModel(
    val id: String,
    val title: String,
    val createdAt: Date,
    val nasheedFile: NasheedFeatureFile,
    val nasheedPoster: NasheedFeaturePoster,
    val currentStartPosition: Int,
    val audioId: String,
)

data class NasheedFeatureFile(
    var name: String,
    var url: String,

    )

data class NasheedFeaturePoster(
    var name: String,
    var url: String,
)