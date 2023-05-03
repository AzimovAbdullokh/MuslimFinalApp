package com.example.book_info.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.book_info.databinding.FragmentBookInfoBinding
import com.example.book_info.presentation.models.BookFeatureModelUi
import com.example.common_api.base.BaseFragment
import com.example.ui_core.extensions.launchWhenViewStarted
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BookInfoFragment :
    BaseFragment<FragmentBookInfoBinding, BookInfoViewModel>(FragmentBookInfoBinding::inflate) {

//    private val bookId: String by lazy(LazyThreadSafetyMode.NONE) {
//        BookInfoFragmentArgs.fromBundle(requireArguments()).id
//    }

    @Inject
    lateinit var factory: BookInfoViewModelFactory.Factory

    override val viewModel: BookInfoViewModel by viewModels { factory.create(bookId = "ZCzh7wKpIB") }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeResource()
    }

    private fun observeResource() = with(viewModel) {
        launchWhenViewStarted {
            bookFlow.observe(::handleBookFetching)
        }
    }

    private fun handleBookFetching(book: BookFeatureModelUi) = with(binding()) {
        val requestOptions = RequestOptions()
            .transforms(CenterCrop(), RoundedCorners(5))
            .timeout(3000)
        Glide.with(requireContext())
            .load(book.poster.url)
            .apply(requestOptions)
            .into(bookImage)

        bookInfoToolbar.toolbarBookTitle.text = book.bookTitle
        bookTitle.text = book.bookTitle
        bookAuthor.text = book.bookAuthor
        bookSubtitle.text = book.bookDescription
    }
}