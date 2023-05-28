package com.example.main_screen.all_books_screen

import androidx.lifecycle.viewModelScope
import com.example.common_api.Mapper
import com.example.common_api.base.BaseViewModel
import com.example.main_screen.domain.models.books.BookMainScreenFeatureModel
import com.example.main_screen.domain.repository.BookMainScreenFeatureRepository
import com.example.main_screen.presentation.models.BooksMainScreenFeatureModelUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class AllBooksViewModel @Inject constructor(
    private val bookMainScreenFeatureRepository: BookMainScreenFeatureRepository,
    private val bookFeatureModelToUiMapper: Mapper<BookMainScreenFeatureModel, BooksMainScreenFeatureModelUi>,
) : BaseViewModel() {

    val bookFlow = bookMainScreenFeatureRepository.fetchAllBooks()
        .map { books -> books.map(bookFeatureModelToUiMapper::map) }
        .stateIn(viewModelScope, SharingStarted.Lazily, BooksMainScreenFeatureModelUi.unknown)

}