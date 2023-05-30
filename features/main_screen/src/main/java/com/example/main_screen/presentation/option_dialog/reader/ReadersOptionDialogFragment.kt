package com.example.main_screen.presentation.option_dialog.reader

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.example.main_screen.R
import com.example.main_screen.databinding.FragmentReadersOptionDialogBinding
import com.example.utils_core.bindingLifecycleError

class ReadersOptionDialogFragment : DialogFragment() {

    private var _binding: FragmentReadersOptionDialogBinding? = null
    val binding get() = _binding ?: bindingLifecycleError()

    private val viewModel: ReadersOptionDialogViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_readers_option_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}