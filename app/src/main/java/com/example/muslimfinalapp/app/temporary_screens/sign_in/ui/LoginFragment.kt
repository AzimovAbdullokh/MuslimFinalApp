package com.example.muslimfinalapp.app.temporary_screens.sign_in.ui

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.common_api.base.BaseFragment
import com.example.muslimfinalapp.R
import com.example.muslimfinalapp.app.MainActivity
import com.example.muslimfinalapp.databinding.FragmentLoginBinding
import com.example.ui_core.custom.snackbar.GenericSnackbar
import com.example.ui_core.extensions.launchWhenStarted
import com.example.utils_core.extensions.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment :
    BaseFragment<FragmentLoginBinding, LoginViewModel>(FragmentLoginBinding::inflate) {

    override val viewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListeners()
        observeData()
    }


    private fun setOnClickListeners() = with(binding()) {
        signInBtn.setOnDownEffectClickListener { signInWithEmail() }
        blockNoAccount.signUpLink.setOnDownEffectClickListener { navigateSignUpFragment() }

    }

    private fun observeData() = with(viewModel) {
        launchWhenStarted {
            successSignInFlow.observe { user ->
                user.userPassword = binding().password.text.toString()
                SharedPreferences().saveCurrentUser(user = user, activity = requireActivity())
                intentClearTask(activity = MainActivity())
            }
        }
    }

    private fun signInWithEmail() = with(binding()) {
        if (!email.validateEmail()) showFixingSnackBar(
            message = getString(com.example.ui_core.R.string.email_input_format_error),
            input = email
        )
        else if (!password.validatePassword()) showFixingSnackBar(
            message = getString(com.example.ui_core.R.string.password_input_format_error),
            input = password
        )
        else startSignIn()
    }

    private fun startSignIn() {
        val email = binding().email.text.toString()
        val password = binding().password.text.toString()
        viewModel.signInWithEmailUseCase(
            email = email,
            password = password
        )
    }

    private fun navigateSignUpFragment() =
        findNavController().navigate(
            LoginFragmentDirections.actionLoginFragmentToSignUpFragment()
        )

}