package com.example.data.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val READERS_TABLE_NAME = "readers_table"

@Entity(tableName = READERS_TABLE_NAME)
class ReadersCache(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "readerId") val readerId: String,
    @ColumnInfo(name = "poster") val readerPoster: ReaderPosterCache,
)

data class ReaderPosterCache(
    val name: String,
    val url: String,
)