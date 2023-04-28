package com.example.muslimfinalapp.app.utils

import android.widget.EditText

const val CONNECT_TIMEOUT_SECONDS = 30L


fun EditText.validateEmail(): Boolean {
    val email = this.text.toString()
    return email.contains("@") && email.contains(".") && email.length > 7
}

fun EditText.validatePassword(): Boolean {
    val password = this.text.toString()
    return password.length >= 8
}

fun EditText.validateName(): Boolean {
    val name = this.text.toString()
    return name.length >= 2
}

fun EditText.validateLastName(): Boolean {
    val lastName = this.text.toString()
    return lastName.length >= 2
}

