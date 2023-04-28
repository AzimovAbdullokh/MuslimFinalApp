package com.example.domain.domain.domain.models.nasheeds

import java.util.*


class NasheedsDomain(
    val id: String,
    val title: String,
    val createdAt: Date,
    val nasheedFile: NasheedFileDomain,
    val nasheedPoster: NasheedPosterDomain,
    val currentStartPosition: Int,
    val audioId: String,
):java.io.Serializable{
    companion object {

        fun unknown() = NasheedsDomain(
            id = String(),
            title = String(),
            createdAt = Date(),
            currentStartPosition = 0,
            nasheedFile = NasheedFileDomain(String(), String()),
            nasheedPoster = NasheedPosterDomain(String(), String()),
            audioId = String(),
        )
    }
}

data class NasheedFileDomain(
    var name: String,
    var url: String,

    )

data class NasheedPosterDomain(
    var name: String,
    var url: String,
)