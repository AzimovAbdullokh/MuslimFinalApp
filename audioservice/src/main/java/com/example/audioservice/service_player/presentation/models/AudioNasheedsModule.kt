package com.example.audioservice.service_player.presentation.models

import java.util.*

data class AudioNasheedsUi(
    val id: String,
    val title: String,
    val createdAt: Date,
    val nasheedFile: NasheedFileUi,
    val nasheedPoster: NasheedPosterUi,
    val currentStartPosition: Int,
    val audioId: String,

    ) {
    companion object {
        fun unknown() = AudioNasheedsUi(id = String(),
            title = String(),
            createdAt = Date(),
            currentStartPosition = 0,
            nasheedFile = NasheedFileUi(String(), String()),
            nasheedPoster = NasheedPosterUi(String(), String()),
            audioId = String())
    }
}

data class NasheedFileUi(
    var name: String,
    var url: String,

    )

data class NasheedPosterUi(
    var name: String,
    var url: String,
)

