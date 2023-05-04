package com.example.sign_in.presentation.ui
//
//import android.os.Bundle
//import android.view.View
//import android.widget.EditText
//import androidx.fragment.app.viewModels
//import com.example.common_api.base.BaseFragment
//import com.example.sign_in.databinding.FragmentLoginBinding
//import com.example.sign_in.exception.pref.SharedPreferences
//import com.example.ui_core.custom.snackbar.GenericSnackbar
//import com.example.ui_core.extensions.launchWhenStarted
//import com.example.utils_core.extensions.setOnDownEffectClickListener
//import dagger.hilt.android.AndroidEntryPoint
//
//@AndroidEntryPoint
//class LoginFragment :
//    BaseFragment<FragmentLoginBinding, LoginViewModel>(FragmentLoginBinding::inflate) {
//
//    override val viewModel: LoginViewModel by viewModels()
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        setOnClickListeners()
//        observeData()
//    }
//
//
//    private fun setOnClickListeners() = with(binding()) {
//        signInBtn.setOnDownEffectClickListener { startSignIn() }
//    }
//
//    private fun observeData() = with(viewModel) {
//        launchWhenStarted {
//            successSignInFlow.observe { user ->
//                user.userPassword = binding().password.text.toString()
//                SharedPreferences().saveCurrentUser(user = user, activity = requireActivity())
////                intentClearTask(activity = MainActivity())
//            }
//        }
//    }
////
////    private fun signInWithEmail() = with(binding()) {
////        if (!email.validateEmail()) showErrorSnackbar(
////            message = getString(R.string.email_input_format_error),
////            input = email
////        )
////        else if (!password.validatePassword()) showErrorSnackbar(
////            message = getString(R.string.password_input_format_error),
////            input = password
////        )
////        else startSignIn()
////    }
//
//    private fun showErrorSnackbar(message: String, input: EditText) =
//        GenericSnackbar
//            .Builder(binding().root)
//            .warning()
//            .message(message)
//            .buttonText("Fix")
//            .buttonClickListener { input.requestFocus() }
//            .build()
//            .show()
//
//
//    private fun startSignIn() {
//        val email = binding().email.text.toString()
//        val password = binding().password.text.toString()
//        viewModel.signInWithEmailUseCase(
//            email = email,
//            password = password
//        )
//    }
//}