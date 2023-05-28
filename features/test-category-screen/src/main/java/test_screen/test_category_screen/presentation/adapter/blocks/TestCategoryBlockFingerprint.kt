package test_screen.test_category_screen.presentation.adapter.blocks

import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.common_api.base.adapter.BaseViewHolder
import com.example.common_api.base.adapter.FingerprintAdapter
import com.example.common_api.base.adapter.Item
import com.example.common_api.base.adapter.ItemFingerprint
import com.example.test_category.R
import com.example.test_category.databinding.MainTestCategoryBlockBinding
import test_screen.test_category_screen.presentation.adapter.items.TestCategoryBlockItem

class TestCategoryBlockFingerprint(
    private val fingerprintsList: List<ItemFingerprint<*, *>>,
    private val viewPool: RecyclerView.RecycledViewPool,
) : ItemFingerprint<MainTestCategoryBlockBinding, TestCategoryBlockItem> {

    override fun isRelativeItem(item: Item) = item is TestCategoryBlockItem

    override fun getLayoutId() = R.layout.main_test_category_block

    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
    ): BaseViewHolder<MainTestCategoryBlockBinding, TestCategoryBlockItem> {
        val binding = MainTestCategoryBlockBinding.inflate(layoutInflater)
        return TestCategoryViewHolder(binding, fingerprintsList, viewPool)
    }

    override fun getDiffUtil() = diffUtil

    private val diffUtil = object : DiffUtil.ItemCallback<TestCategoryBlockItem>() {

        override fun areItemsTheSame(
            oldItem: TestCategoryBlockItem,
            newItem: TestCategoryBlockItem,
        ) = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: TestCategoryBlockItem,
            newItem: TestCategoryBlockItem,
        ) = oldItem == newItem

    }

}

class TestCategoryViewHolder(
    binding: MainTestCategoryBlockBinding,
    fingerprints: List<ItemFingerprint<*, *>>,
    viewPool: RecyclerView.RecycledViewPool,
) : BaseViewHolder<MainTestCategoryBlockBinding, TestCategoryBlockItem>(binding) {

    private val fingerprintAdapter = FingerprintAdapter(fingerprints)

    init {
        with(binding.horizontalRecyclerView) {
            adapter = fingerprintAdapter
            setRecycledViewPool(viewPool)
        }
    }

    override fun onBind(item: TestCategoryBlockItem) {
        super.onBind(item)
        setupViews()
    }

    private fun setupViews() = with(binding) {
        fingerprintAdapter.submitList(item.items)
        horizontalRecyclerView.restoreState(item.state)
    }

    override fun onViewDetached() {
        binding.horizontalRecyclerView.onFlingListener = null
        item.state = binding.horizontalRecyclerView.layoutManager?.onSaveInstanceState() ?: return
    }

    private fun RecyclerView.restoreState(parcelable: Parcelable?) {
        if (parcelable == null) return
        layoutManager?.onRestoreInstanceState(parcelable)
    }

}