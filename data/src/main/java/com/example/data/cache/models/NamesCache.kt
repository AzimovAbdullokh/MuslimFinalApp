package com.example.data.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val NAMES_TABLE_NAME = "names_table"

@Entity(tableName = NAMES_TABLE_NAME)
class NamesCache(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "image") val image: NamesPosterCache,
)

data class NamesPosterCache(
    var name: String,
    var url: String,
)