package com.example.domain.domain.domain.models

import com.example.domain.domain.domain.models.books.BookDomain
import com.example.domain.domain.domain.models.khadisses.KhadisDomain
import com.example.domain.domain.domain.models.nasheeds.NasheedsDomain
import com.example.domain.domain.domain.models.readers.ReaderDomain

data class MainScreenItems(
    val books: List<BookDomain>,
    val audioNasheeds: List<NasheedsDomain>,
    val khadisses: List<KhadisDomain>,
    val readers: List<ReaderDomain>,
)