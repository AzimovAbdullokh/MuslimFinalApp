package com.example.data.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

const val AUDIO_NASHEEDS_TABLE_NAME = "audio_nasheeds_table"

@Entity(tableName = AUDIO_NASHEEDS_TABLE_NAME)
class AudioNasheedsCashe(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "created_at") val createdAt: Date,
    @ColumnInfo(name = "nasheed") val nasheedFile: AudioNasheedFileCache,
    @ColumnInfo(name = "nasheedImg") val nasheedPoster: AudioNasheedPosterCache,
    @ColumnInfo(name = "audioId") val audioId: String,
) {
    companion object {
        val unknown = AudioNasheedsCashe(
            id = String(),
            title = String(),
            createdAt = Date(),
            nasheedFile = AudioNasheedFileCache.unknown,
            nasheedPoster = AudioNasheedPosterCache.unknown,
            audioId = String()
        )
    }
}

data class AudioNasheedFileCache(
    val name: String,
    val url: String,
) {
    companion object {
        val unknown = AudioNasheedFileCache(name = String(), url = String())
    }
}

data class AudioNasheedPosterCache(
    val name: String,
    val url: String,
) {
    companion object {
        val unknown = AudioNasheedPosterCache(name = String(), url = String())
    }
}