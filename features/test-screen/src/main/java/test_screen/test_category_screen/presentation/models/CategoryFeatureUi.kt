package test_screen.test_category_screen.presentation.models

data class CategoryFeatureUi(
    val id: String,
    val titles: String,
    val descriptions: String,
    val poster: CategoryFeaturePosterui,
)

data class CategoryFeaturePosterui(
    var name: String,
    var url: String,
)