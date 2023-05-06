package com.example.sign_up.ui

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.fragment.app.viewModels
import com.example.common_api.base.BaseFragment
import com.example.sign_up.databinding.FragmentSignUpBinding
import com.example.ui_core.custom.snackbar.GenericSnackbar
import com.example.utils_core.extensions.setOnDownEffectClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentSignUp : BaseFragment<FragmentSignUpBinding, FragmentSignUpViewModel>(
    FragmentSignUpBinding::inflate
) {

    override val viewModel: FragmentSignUpViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        setOnClickListeners()
    }

//
//    private fun setOnClickListeners() = with(binding()) {
//        signUpBtn.setOnDownEffectClickListener { validateUserValuesAndStartSignUp() }
//    }
//
//
//    private fun startSignUp() = with(binding()) {
//        val newUser = UserSignUp(
//            username = "Abdullokh",
//            firstName = firstNameField.text.toString().trim(),
//            lastName = lastNameField.text.toString().trim(),
//            email = emailField.text.toString().trim(),
//            password = passwordField.text.toString().trim(),
//        )
//        viewModel.signUpUser(user = newUser)
//
//    }
//    private fun observeData() = with(viewModel) {
//        launchWhenStarted {
//            successSignInFlow.observe {
//                handleSignUp()
//            }
//        }
//    }

//    private fun handleSignUp() {
////        navControllerPopBackStackInclusive()
//        findNavController().navigate(
//            R.id.main_navigation,
//            bundleOf(),
//        )
//    }
//
//    private fun navControllerPopBackStackInclusive() =
//        findNavController().popBackStack(R.id.login_navigation, false)

    private fun showErrorSnackbar(message: String, input: EditText) =
        GenericSnackbar
            .Builder(binding().root)
//            .error()
            .message(message)
            .buttonText(getString(com.example.ui_core.R.string.fix))
            .buttonClickListener { input.requestFocus() }
            .build()
            .show()
}