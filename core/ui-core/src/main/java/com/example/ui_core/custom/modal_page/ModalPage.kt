package com.example.ui_core.custom.modal_page

import androidx.fragment.app.Fragment


open class ModalPage private constructor() {

    companion object {
        val TAG: String? = ModalPage::class.java.canonicalName
    }

    data class Builder(
        private var title: String = "",
        private var showCloseIcon: Boolean = false,
        private var isCancelable: Boolean = true,
        private var minHeight: Float = 0f,
        private var maxHeight: Float = 1f,
        private var fragment: Fragment? = null
    ) {

        fun title(title: String): Builder {
            this.title = title
            return this
        }

        fun fragment(fragment: Fragment): Builder {
            this.fragment = fragment
            return this
        }

        fun build() = ModalPageFragment(
            title,
            showCloseIcon,
            isCancelable,
            minHeight,
            maxHeight,
            fragment
        )
    }
}