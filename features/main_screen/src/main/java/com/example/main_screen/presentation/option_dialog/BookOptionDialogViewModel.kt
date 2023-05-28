package com.example.main_screen.presentation.option_dialog

import androidx.lifecycle.viewModelScope
import com.example.common_api.DispatchersProviderInCommonApi
import com.example.common_api.Mapper
import com.example.common_api.base.BaseViewModel
import com.example.main_screen.domain.models.books.BookMainScreenFeatureModel
import com.example.main_screen.domain.repository.BookMainScreenFeatureRepository
import com.example.main_screen.presentation.models.BooksMainScreenFeatureModelUi
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.*


class BookOptionDialogViewModel @AssistedInject constructor(
    @Assisted private val bookId: String,
    private val booksRepository: BookMainScreenFeatureRepository,
    private val bookMainScreenFeatureModelToUiMapper: Mapper<BookMainScreenFeatureModel, BooksMainScreenFeatureModelUi>,
) : BaseViewModel() {

    private val bookIdFlow = MutableStateFlow(bookId)

    val bookFlow = bookIdFlow.flatMapLatest(booksRepository::fetchBookObservableByOne)
        .map(bookMainScreenFeatureModelToUiMapper::map)
        .stateIn(viewModelScope, SharingStarted.Lazily, BooksMainScreenFeatureModelUi.unknown)

    @AssistedFactory
    interface Factory {
        fun create(
            bookId: String
        ): BookOptionDialogViewModel
    }
}