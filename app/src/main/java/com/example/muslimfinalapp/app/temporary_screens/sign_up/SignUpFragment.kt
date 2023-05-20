package com.example.muslimfinalapp.app.temporary_screens.sign_up

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.common_api.base.BaseFragment
import com.example.muslimfinalapp.R
import com.example.muslimfinalapp.app.temporary_screens.sign_up.models.UserSignUp
import com.example.muslimfinalapp.databinding.FragmentSignUpBinding
import com.example.ui_core.custom.snackbar.GenericSnackbar
import com.example.ui_core.extensions.launchOnLifecycle
import com.example.ui_core.extensions.launchWhenViewStarted
import com.example.utils_core.extensions.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment :
    BaseFragment<FragmentSignUpBinding, SignUpViewModel>(FragmentSignUpBinding::inflate) {
    override val viewModel: SignUpViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListeners()
        observeData()
    }

    private fun setOnClickListeners() = with(binding()) {
        signUpBtn.setOnDownEffectClickListener { validateUserValuesAndStartSignUp() }
        upButton.setOnDownEffectClickListener { viewModel.navigateBack() }
    }

    private fun validateUserValuesAndStartSignUp() = with(binding()) {
        when {
            !firstNameField.validateName() -> showErrorSnackbar(
                message = getString(com.example.ui_core.R.string.name_input_format_error),
                input = firstNameField,
            )
            !lastNameField.validateLastName() -> showErrorSnackbar(
                message = getString(com.example.ui_core.R.string.last_name_input_format_error),
                input = lastNameField,
            )
            !loginField.validateLogin() -> showErrorSnackbar(
                message = getString(com.example.ui_core.R.string.login_input_format_error),
                input = loginField,
            )
            !emailField.validateEmail() -> showErrorSnackbar(
                message = getString(com.example.ui_core.R.string.email_input_format_error),
                input = emailField,
            )
            !passwordField.validatePassword() -> showErrorSnackbar(
                message = getString(com.example.ui_core.R.string.password_input_format_error),
                input = passwordField,
            )
            !ageField.validateAge() -> showErrorSnackbar(
                message = getString(com.example.ui_core.R.string.age_input_format_error),
                input = passwordField,
            )
            else -> {
                startSignUp()
                showSuccessSnackBar("you have successfully registered")
            }
        }
    }

    private fun startSignUp() = with(binding()) {
        val newUser = UserSignUp(
            firstName = firstNameField.text.toString().trim(),
            lastName = lastNameField.text.toString().trim(),
            userLogin = loginField.text.toString().trim(),
            userEmail = emailField.text.toString().trim(),
            userPassword = passwordField.text.toString().trim(),
            age = ageField.text.toString().trim(),
            userType = "user",
        )
        viewModel.startSignUp(newUser)
    }


    private fun observeData() = with(viewModel) {
        launchOnLifecycle {
            isProgressBarVisibleFlow.observe(::setProgressBarVisibility)
        }
        launchWhenViewStarted {
            isErrorMessageVisibleFlow.observe(::setErrorMessageVisibility)
            isProgressDialogVisibleFlow.observe(::handleProgressDialogStatus)
            handleSignUpFlow.observe {
                findNavController().navigate(
                    R.id.main_bottom,
                    bundleOf(),
                    createNavOptionsWithAnimations()
                )
            }
        }
    }

    private fun createNavOptionsWithAnimations() =
        NavOptions
            .Builder()
            .setEnterAnim(com.example.ui_core.R.anim.slide_up)
            .setExitAnim(com.example.ui_core.R.anim.slide_down)
            .setPopEnterAnim(com.example.ui_core.R.anim.slide_up)
            .setPopExitAnim(com.example.ui_core.R.anim.slide_down).build()


    private fun navControllerPopBackStackInclusive() =
        findNavController().popBackStack(R.id.login_navigation, false)


    private fun handleProgressDialogStatus(isShow: Boolean) {
//        if (isShow) progressDialog.showOnlyOne(parentFragmentManager)
//        else progressDialog.dismiss()
    }

    private fun setProgressBarVisibility(isVisible: Boolean) {
//        binding().progressBar.isVisible = isVisible
//        binding().nextButton.isVisible = !isVisible
    }

    private fun setErrorMessageVisibility(isVisible: Boolean) {
//        binding().errorMessage.isVisible = isVisible
    }

    private fun showErrorSnackbar(message: String, input: EditText) =
        GenericSnackbar
            .Builder(binding().root)
            .error()
            .message(message)
            .buttonText("Fix")
            .buttonClickListener { input.requestFocus() }
            .build()
            .show()

}