package com.example.data.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

const val KHADISSES_TABLE_NAME = "khadisses_table"

@Entity(tableName = KHADISSES_TABLE_NAME)
class KhadissesCache(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "created_at") val createdAt: Date,
    @ColumnInfo(name = "khadisDescription") val khadisDescription: String,
    @ColumnInfo(name = "theme") val khadisSubject: String,
    @ColumnInfo(name = "khadisId") val khadisId: String,
)