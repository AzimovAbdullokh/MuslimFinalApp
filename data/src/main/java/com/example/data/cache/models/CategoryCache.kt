package com.example.data.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val CATEGORIES_TABLE_NAME = "categories_table"


@Entity(tableName = CATEGORIES_TABLE_NAME)
class CategoryCache(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "titles") val titles: String,
    @ColumnInfo(name = "descriptions") val descriptions: String,
    @ColumnInfo(name = "poster") val poster: CategoryPosterCache,
)

data class CategoryPosterCache(
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "url") var url: String,
)