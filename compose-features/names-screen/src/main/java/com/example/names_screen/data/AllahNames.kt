package com.example.names_screen.data

import java.io.Serializable

data class AllahNames(
    val id: Int,
    val artist: String,
    val imageId: Int,
    val swiped: Boolean = false
) : Serializable