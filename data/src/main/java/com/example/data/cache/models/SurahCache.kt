package com.example.data.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val SURAH_TABLE_NAME = "surah_table"


@Entity(tableName = SURAH_TABLE_NAME)
data class SurahCache(
    @PrimaryKey var id: String,
    @ColumnInfo(name = "surah") var surah: String,
    @ColumnInfo(name = "surahId") var surahId: String,
    @ColumnInfo(name = "surahName") var surahName: String,
    @ColumnInfo(name = "surahArabName") var surahArabName: String,
    @ColumnInfo(name = "surahCountInQuran") var surahCountInQuran: String,
)