package com.example.book_info.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.book_info.domain.models.BookFeatureModelDomain
import com.example.book_info.domain.repository.BookFeatureModuleRepository
import com.example.book_info.presentation.models.BookFeatureModelUi
import com.example.common_api.Mapper
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

const val BOOK_KEY = "BOOK_KEY"

class BookInfoViewModelFactory @AssistedInject constructor(
    @Assisted(BOOK_KEY) private val bookId: String,
    private val bookRepository: BookFeatureModuleRepository,
    private val bookDomainToBookMapper: Mapper<BookFeatureModelDomain, BookFeatureModelUi>,
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == BookInfoViewModel::class.java)
        return BookInfoViewModel(
            bookId = bookId,
            bookRepository = bookRepository,
            bookDomainToBookMapper = bookDomainToBookMapper
        ) as T
    }
    @AssistedFactory
    interface Factory {

        fun create(@Assisted(BOOK_KEY) bookId: String): BookInfoViewModelFactory
    }
}