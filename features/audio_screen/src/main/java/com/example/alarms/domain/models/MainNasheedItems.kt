package com.example.alarms.domain.models

import com.example.alarms.domain.models.books.BookFeatureModel
import com.example.alarms.domain.models.nasheeds.NasheedsFeatureModel
import com.example.alarms.domain.models.readers.ReadersFeatureModel

data class MainNasheedItems(
    val books: List<BookFeatureModel>,
    val nasheeds: List<NasheedsFeatureModel>,
    val readers: List<ReadersFeatureModel>,
)