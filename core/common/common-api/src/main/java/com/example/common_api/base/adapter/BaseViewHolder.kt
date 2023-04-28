package com.example.common_api.base.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.ui_core.custom.snackbar.GenericSnackbar

abstract class BaseViewHolder<out V : ViewBinding, I : Item>(
    val binding: V
) : RecyclerView.ViewHolder(binding.root) {

    lateinit var item: I

    open fun onBind(item: I) {
        this.item = item
    }

    open fun onBind(item: I, payloads: List<Any>) {
        this.item = item
    }

    open fun onViewDetached() = Unit

    fun showErrorSnackbar(message: String) =
        GenericSnackbar
            .Builder(binding.root)
            .error()
            .message(message)
            .build()
            .show()

    fun showSuccessSnackBar(message: String) =
        GenericSnackbar
            .Builder(binding.root)
            .success()
            .message(message)
            .build()
            .show()

    fun showInfoSnackBar(message: String) =
        GenericSnackbar
            .Builder(binding.root)
            .info()
            .message(message)
            .build()
            .show()
}