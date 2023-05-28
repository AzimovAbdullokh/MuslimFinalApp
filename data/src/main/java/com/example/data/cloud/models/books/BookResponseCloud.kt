package com.example.data.cloud.models.books

import com.google.gson.annotations.SerializedName
import java.util.*

data class BookResponseCloud(
    @SerializedName("results") val books: List<BookCloud>,
)

data class BookCloud(
    @SerializedName("bookTitle") val bookTitle: String,
    @SerializedName("bookAuthor") val bookAuthor: String,
    @SerializedName("objectId") var id: String,
    @SerializedName("createdAt") var createdAt: Date,
    @SerializedName("bookDescription") val bookDescription: String,
    @SerializedName("book") var book: BookPdfCloud,
    @SerializedName("bookPoster") var poster: BookPosterCloud,
    @SerializedName("publicYear") val publicYear: String,
    @SerializedName("pages") val pages: String,
    @SerializedName("format") val bookFormat: String,


    ) {
    companion object {
        val unknown = BookCloud(
            id = String(),
            bookAuthor = String(),
            bookTitle = String(),
            bookDescription = String(),
            book = BookPdfCloud(String(), String(), String()),
            poster = BookPosterCloud(String(), String(), String()),
            createdAt = Date(),
            pages = String(),
            publicYear = String(),
            bookFormat = String()
        )
    }
}


data class BookPdfCloud(
    @SerializedName("name") var name: String,
    @SerializedName("__type") var type: String,
    @SerializedName("url") var url: String,
)

data class BookPosterCloud(
    @SerializedName("name") var name: String,
    @SerializedName("__type") var type: String,
    @SerializedName("url") var url: String,
)