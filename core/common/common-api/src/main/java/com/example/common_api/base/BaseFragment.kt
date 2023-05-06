package com.example.common_api.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import androidx.navigation.fragment.findNavController
import com.example.common_api.R
import com.example.common_api.navigateTo
import com.example.common_api.navigation.NavigationCommand
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
        collectNavigation(viewLifecycleOwner) {
            it.getValue()?.let { navigationCommand ->
                handleNavigation(navigationCommand)
            }
        }
    }

    private fun handleNavigation(navCommand: NavigationCommand) {
        when (navCommand) {
            is NavigationCommand.ToDirection -> findNavController().navigate(navCommand.directions.actionId)
            is NavigationCommand.Back -> findNavController().navigateUp()
        }
    }


//    fun showBottomNavigationView() = bottomNavigationView?.apply { show() }
//
//    fun hideBottomNavigationView() = bottomNavigationView?.apply { hide() }

    fun showFixingSnackBar(message: String, input:EditText) =
        GenericSnackbar
            .Builder(binding().root)
            .error()
            .message(message)
            .buttonText(getString(com.example.ui_core.R.string.fix))
            .buttonClickListener { input.requestFocus() }
            .build()
            .show()

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