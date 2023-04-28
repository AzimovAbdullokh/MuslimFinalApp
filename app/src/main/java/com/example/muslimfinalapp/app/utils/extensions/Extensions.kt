package com.example.muslimfinalapp.app.utils.extensions

import android.app.Activity
import android.content.Intent
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.downloader.Progress

fun Activity.intentClearTask(activity: Activity) {
    val intent = Intent(this, activity::class.java)
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    startActivity(intent)
}

fun Fragment.intentClearTask(activity: Activity) {
    val intent = Intent(requireActivity(), activity::class.java)
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    startActivity(intent)
    Animatoo.animateSlideDown(requireActivity())
}

fun EditText.checkPassword(): Boolean {
    val password = this.text.toString()
    return password.length >= 8
}

fun EditText.checkName(): Boolean {
    val name = this.text.toString()
    return name.length >= 2
}

fun EditText.checkLastName(): Boolean {
    val lastName = this.text.toString()
    return lastName.length >= 2
}

fun EditText.checkEmail(): Boolean {
    val email = this.text.toString()
    return email.contains("@") && email.contains(".") && email.length > 7
}

fun Progress.calculateProgress() =
    ((this.currentBytes * 100) / this.totalBytes).toInt()

fun Progress.calculateProgressString(): String {
    val currentByte = (this.currentBytes / 1_000_000).toInt()
    val totalByte = (this.totalBytes / 1_000_000).toInt()
    return "$currentByte".plus(" mb / $totalByte mb")
}