package com.example.muslimfinalapp.app.glue.audio_screen.gluing_repository

import com.example.alarms.domain.models.books.BookFeatureModel
import com.example.alarms.domain.repository.BookFeatureRepository
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.books.BookDomain
import com.example.domain.domain.domain.repositories.BookRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class AdapterBooksFeatureRepository @Inject constructor(
    private val bookRepository: BookRepository,
    private val bookDomainToBookModuleDomainMapper: Mapper<BookDomain, BookFeatureModel>,
) : BookFeatureRepository {

    override fun fetchAllBooks(): Flow<List<BookFeatureModel>> =
        bookRepository.fetchAllBooks()
            .map { book -> book.map(bookDomainToBookModuleDomainMapper::map) }
}