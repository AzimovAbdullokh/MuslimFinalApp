package com.example.book_info.presentation

import androidx.lifecycle.viewModelScope
import com.example.book_info.domain.models.BookFeatureModelDomain
import com.example.book_info.domain.repository.BookFeatureModuleRepository
import com.example.book_info.presentation.models.BookFeatureModelUi
import com.example.common_api.Mapper
import com.example.common_api.base.BaseViewModel
import kotlinx.coroutines.flow.*


class BookInfoViewModel(
    private val bookId: String,
    private val bookRepository: BookFeatureModuleRepository,
    private val bookDomainToBookMapper: Mapper<BookFeatureModelDomain, BookFeatureModelUi>,
) : BaseViewModel() {

    private val bookIdFlow = MutableStateFlow(bookId)


    val bookFlow = bookIdFlow.flatMapLatest(bookRepository::fetchBookObservable)
        .map(bookDomainToBookMapper::map)
        .stateIn(viewModelScope, SharingStarted.Lazily, BookFeatureModelUi.unknown)
}