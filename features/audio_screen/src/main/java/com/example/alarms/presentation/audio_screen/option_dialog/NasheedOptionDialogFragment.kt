package com.example.alarms.presentation.audio_screen.option_dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.alarms.databinding.FragmentNasheedOptionDialogBinding
import com.example.ui_core.custom.modal_page.ModalPage
import com.example.utils_core.bindingLifecycleError
import com.example.utils_core.extensions.setOnDownEffectClickListener

class NasheedOptionDialogFragment : DialogFragment() {

    private var _binding: FragmentNasheedOptionDialogBinding? = null
    val binding get() = _binding ?: bindingLifecycleError()

    private val nashedId: String by lazy(LazyThreadSafetyMode.NONE) {
        requireArguments().getString(NASHEED_KEY, String()) ?: String()
    }

    private var listener: NasheedOptionDialogClickListeners? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentNasheedOptionDialogBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickers()
        binding.title.text = "Nasheed Title is null"
        binding.author.text = "Nasheed Description is null"
    }

    private fun setClickers() = with(binding) {
        saveNasheedBlock.setOnDownEffectClickListener {}
    }


    companion object {
        private const val NASHEED_KEY = "NASHEED_KEY"

        @JvmStatic
        fun newInstance(
            nashedId: String,
            listener: NasheedOptionDialogClickListeners,
        ) = NasheedOptionDialogFragment().run {
            this.listener = listener
            arguments = Bundle().apply { putString(NASHEED_KEY, nashedId) }
            ModalPage.Builder().fragment(this).build()
        }
    }
}