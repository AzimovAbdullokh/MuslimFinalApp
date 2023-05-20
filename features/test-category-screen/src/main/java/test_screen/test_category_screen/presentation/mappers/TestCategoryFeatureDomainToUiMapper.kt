package test_screen.test_category_screen.presentation.mappers

import com.example.common_api.Mapper
import test_screen.test_category_screen.domain.models.CategoryFeatureDomain
import test_screen.test_category_screen.presentation.models.CategoryFeaturePosterui
import test_screen.test_category_screen.presentation.models.CategoryFeatureUi
import test_screen.test_category_screen.presentation.models.CategoryTypes
import javax.inject.Inject

class TestCategoryFeatureDomainToUiMapper @Inject constructor() :
    Mapper<CategoryFeatureDomain, CategoryFeatureUi> {
    override fun map(from: CategoryFeatureDomain) = from.run {
        CategoryFeatureUi(
            id = id,
            titles = titles,
            descriptions = descriptions,
            poster = CategoryFeaturePosterui(name = poster.name, url = poster.url),
            type = CategoryTypes.PROROK
        )
    }
}