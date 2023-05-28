package com.example.muslimfinalapp.app.temporary_screens.book_details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.common_api.base.BaseFragment
import com.example.muslimfinalapp.databinding.FragmentBookDetailsBinding

class BookDetailsFragment :
    BaseFragment<FragmentBookDetailsBinding, BookDetailsViewModel>(FragmentBookDetailsBinding::inflate) {

    override val viewModel: BookDetailsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}