package com.example.common_api.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import androidx.navigation.fragment.findNavController
import com.example.common_api.navigateTo
import com.example.ui_core.custom.snackbar.GenericSnackbar
import com.example.ui_core.extensions.launchWhenViewStarted

abstract class BaseFragment<V : ViewBinding, VM : BaseViewModel>(
    private val binder: (LayoutInflater, ViewGroup?, Boolean) -> V,
) : Fragment() {

    protected abstract val viewModel: VM

    private var viewBinding: V? = null

    protected fun binding(): V = checkNotNull(viewBinding)

//    private val bottomNavigationView: BottomNavigationView? by lazy(LazyThreadSafetyMode.NONE) {
//        requireActivity().findViewById<BottomNavigationView>(com.example.muslimfinalapp.R.id.bottomNavigationView) ?: null
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val binding = binder.invoke(inflater, container, false)
        this.viewBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeRecourse()
    }

    private fun observeRecourse() = with(viewModel) {
        launchWhenViewStarted {
            navCommand.observe(findNavController()::navigateTo)
        }
    }


//    fun showBottomNavigationView() = bottomNavigationView?.apply { show() }
//
//    fun hideBottomNavigationView() = bottomNavigationView?.apply { hide() }

    fun showErrorSnackbar(message: String) =
        GenericSnackbar
            .Builder(binding().root)
            .error()
            .message(message)
            .build()
            .show()


    fun showSuccessSnackBar(message: String) =
        GenericSnackbar
            .Builder(binding().root)
            .success()
            .message(message)
            .build()
            .show()


    fun showInfoSnackBar(message: String) =
        GenericSnackbar
            .Builder(binding().root)
            .info()
            .message(message)
            .build()
            .show()

}