package test_screen.test_category_screen.presentation.adapter.items

import android.os.Parcelable
import com.example.common_api.base.adapter.Item

data class TestCategoryBlockItem(
    val items: List<Item>,
    var state: Parcelable? = null,
) : Item