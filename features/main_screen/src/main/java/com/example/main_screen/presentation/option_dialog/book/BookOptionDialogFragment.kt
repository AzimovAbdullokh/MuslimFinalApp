package com.example.main_screen.presentation.option_dialog.book

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.main_screen.databinding.FragmentBookOptionDialogBinding
import com.example.main_screen.presentation.models.BooksMainScreenFeatureModelUi
import com.example.ui_core.custom.modal_page.ModalPage
import com.example.ui_core.extensions.assistedViewModel
import com.example.ui_core.extensions.launchWhenViewStarted
import com.example.utils_core.bindingLifecycleError
import com.example.utils_core.extensions.showImage
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BookOptionDialogFragment : DialogFragment() {

    private var _binding: FragmentBookOptionDialogBinding? = null
    val binding get() = _binding ?: bindingLifecycleError()

    private val bookId: String by lazy(LazyThreadSafetyMode.NONE) {
        requireArguments().getString(BOOK_KEY, String()) ?: String()
    }

    @Inject
    lateinit var factory: BookOptionDialogViewModel.Factory
    private val viewModel: BookOptionDialogViewModel by assistedViewModel {
        factory.create(bookId = bookId)
    }

    private var listener: BookOptionDialogClickListeners? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentBookOptionDialogBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        launchWhenViewStarted {
            viewModel.bookFlow.observe(::bookDetailsFetching)
        }
    }

    private fun bookDetailsFetching(book: BooksMainScreenFeatureModelUi) = with(binding) {
        requireContext().showImage(uri = book.poster.url, bookPoster)
        title.text = book.bookTitle
        authorText.text = book.bookAuthor
        description.text = book.bookDescription
        publicYearText.text = book.publicYear
        formatText.text = book.bookFormat
        pagesText.text = book.pages
    }

    companion object {
        private const val BOOK_KEY = "BOOK_KEY"

        @JvmStatic
        fun newInstance(
            nashedId: String,
            listener: BookOptionDialogClickListeners,
        ) = BookOptionDialogFragment().run {
            this.listener = listener
            arguments = Bundle().apply { putString(BOOK_KEY, nashedId) }
            ModalPage.Builder().fragment(this).build()
        }
    }
}