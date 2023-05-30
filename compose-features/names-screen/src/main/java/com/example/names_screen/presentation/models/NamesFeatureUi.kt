package com.example.names_screen.presentation.models

data class NamesFeatureUi(
    val id: String,
    val name: String,
    val image: NameFeaturePosterUI,
){
    companion object{
        fun unknown() = NamesFeatureUi(
            id = String(),
            name = String(),
            image = NameFeaturePosterUI.unknown()
        )
    }
}



data class NameFeaturePosterUI(
    var name: String,
    var url: String,
){
    companion object{
        fun unknown() = NameFeaturePosterUI(
            name = String(),
            url = String()
        )
    }
}