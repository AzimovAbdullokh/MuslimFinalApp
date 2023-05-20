package test_screen.test_category_screen.domain.models

data class CategoryFeatureDomain(
    val id: String,
    val titles: String,
    val descriptions: String,
    val poster: CategoryFeaturePosterDomain,
)

data class CategoryFeaturePosterDomain(
    var name: String,
    var url: String,
)