package test_screen.test_category_screen.presentation.adapter.fingerprints

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.common_api.base.adapter.BaseViewHolder
import com.example.common_api.base.adapter.Item
import com.example.common_api.base.adapter.ItemFingerprint
import com.example.test_category.R
import com.example.test_category.databinding.ItemTestCategoryBinding
import com.example.utils_core.extensions.setOnDownEffectClickListener
import com.example.utils_core.extensions.showImage
import com.example.utils_core.extensions.startSlideInLeftAnim
import test_screen.test_category_screen.presentation.models.CategoryFeatureAdapterModel
import test_screen.test_category_screen.presentation.models.CategoryTypes

class TestCategoryFingerprint :
    ItemFingerprint<ItemTestCategoryBinding, CategoryFeatureAdapterModel> {

    override fun isRelativeItem(item: Item) = item is CategoryFeatureAdapterModel

    override fun getLayoutId() = R.layout.item_test_category

    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
    ): BaseViewHolder<ItemTestCategoryBinding, CategoryFeatureAdapterModel> {
        val binding = ItemTestCategoryBinding.inflate(layoutInflater, parent, false)
        return BooksViewHolder(binding)
    }

    override fun getDiffUtil() = diffUtil

    private val diffUtil = object : DiffUtil.ItemCallback<CategoryFeatureAdapterModel>() {

        override fun areItemsTheSame(
            oldItem: CategoryFeatureAdapterModel,
            newItem: CategoryFeatureAdapterModel,
        ) = oldItem.id() == newItem.id()

        override fun areContentsTheSame(
            oldItem: CategoryFeatureAdapterModel,
            newItem: CategoryFeatureAdapterModel,
        ) = oldItem == newItem
    }
}

class BooksViewHolder(
    binding: ItemTestCategoryBinding,
) : BaseViewHolder<ItemTestCategoryBinding, CategoryFeatureAdapterModel>(binding) {

    override fun onBind(item: CategoryFeatureAdapterModel) {
        super.onBind(item)
        setupViews()
        setOnClickListeners()
    }

    private fun setupViews() = with(binding) {
        cardContainer.startSlideInLeftAnim()
        poster.context.showImage(item.testCategories.poster.url, poster)
//        title.text = item.testCategories.titles
        description.text = item.testCategories.descriptions
    }

    private fun setOnClickListeners() = with(binding) {
        goTest.setOnDownEffectClickListener {
            item.listener.categoryItemOnCLick(item.testCategories.type)
        }
    }
}