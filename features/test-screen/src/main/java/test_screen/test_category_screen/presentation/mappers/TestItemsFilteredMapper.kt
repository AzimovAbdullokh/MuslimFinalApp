package test_screen.test_category_screen.presentation.mappers

import com.example.common_api.Mapper
import com.example.common_api.base.adapter.Item
import test_screen.test_category_screen.domain.models.CategoryFeatureDomain
import test_screen.test_category_screen.domain.models.MainTestCategoryItems
import test_screen.test_category_screen.presentation.adapter.items.TestCategoryBlockItem
import test_screen.test_category_screen.presentation.listener.CategoryItemClickListener
import test_screen.test_category_screen.presentation.models.CategoryFeatureAdapterModel
import test_screen.test_category_screen.presentation.models.CategoryFeatureUi
import javax.inject.Inject

interface TestItemsFilteredMapper {


    fun map(
        items: MainTestCategoryItems,
        searchQuery: String,
        categoryItemClickListener: CategoryItemClickListener,
    ): Triple<List<Item>, List<Item>, List<Item>>

}

class TestItemsFilteredMapperImpl @Inject constructor(
    private val testCategoryFeatureDomainToUiMapper: Mapper<CategoryFeatureDomain, CategoryFeatureUi>,
) : TestItemsFilteredMapper {

    override fun map(
        items: MainTestCategoryItems,
        searchQuery: String,
        categoryItemClickListener: CategoryItemClickListener,
    ): Triple<List<Item>, List<Item>, List<Item>> {


        val filteredTestCategoryList = items.testCategories
                .map(testCategoryFeatureDomainToUiMapper::map)
                .filter { applyFilterForAllTestCategories(it, searchQuery) }
                .map {
                    CategoryFeatureAdapterModel(testCategories =
                        CategoryFeatureUi(
                            id = it.id,
                            titles = it.titles,
                            descriptions = it.descriptions,
                            poster = it.poster), listener = categoryItemClickListener)
                }


        val allItems = mutableListOf<Item>()

        val testCategoryItem = TestCategoryBlockItem(filteredTestCategoryList)
        if (testCategoryItem.items.isNotEmpty()) allItems.addAll(listOf(testCategoryItem))

        return Triple(allItems, emptyList(), emptyList())
    }

    private fun applyFilterForAllTestCategories(category: CategoryFeatureUi, searchQuery: String) =
        if (searchQuery.isEmpty()) category.titles != String()
        else category.titles.contains(searchQuery, ignoreCase = true)


}