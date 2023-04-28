package com.example.data.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "book_table")
data class BookCache(
    @PrimaryKey var id: String,
    @ColumnInfo(name = "created_at") var createdAt: Date,
    @ColumnInfo(name = "bookTitle") val bookTitle: String,
    @ColumnInfo(name = "bookAuthor") val bookAuthor: String,
    @ColumnInfo(name = "bookDescription") var bookDescription: String,
    @ColumnInfo(name = "book") var book: BookPdfCache,
    @ColumnInfo(name = "bookPoster") var bookPoster: BookPosterCache,
)

data class BookPdfCache(
    var name: String,
    var type: String,
    var url: String,
)

data class BookPosterCache(
    var name: String,
    var url: String,
    var type: String,
)