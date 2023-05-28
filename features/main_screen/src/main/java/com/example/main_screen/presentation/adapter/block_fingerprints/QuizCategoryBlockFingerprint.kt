package com.example.main_screen.presentation.adapter.block_fingerprints

import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.common_api.base.adapter.BaseViewHolder
import com.example.common_api.base.adapter.FingerprintAdapter
import com.example.common_api.base.adapter.Item
import com.example.common_api.base.adapter.ItemFingerprint
import com.example.main_screen.R
import com.example.main_screen.databinding.MainScreenTestCategoryBlockBinding
import com.example.main_screen.presentation.adapter.items.TestCategoryBlockItem

class QuizCategoryBlockFingerprint(
    private val fingerprintsList: List<ItemFingerprint<*, *>>,
    private val viewPool: RecyclerView.RecycledViewPool,
) : ItemFingerprint<MainScreenTestCategoryBlockBinding, TestCategoryBlockItem> {

    override fun isRelativeItem(item: Item) = item is TestCategoryBlockItem

    override fun getLayoutId() = R.layout.main_screen_test_category_block

    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
    ): BaseViewHolder<MainScreenTestCategoryBlockBinding, TestCategoryBlockItem> {
        val binding = MainScreenTestCategoryBlockBinding.inflate(layoutInflater)
        return QuizCategoryViewHolder(binding, fingerprintsList, viewPool)
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

class QuizCategoryViewHolder(
    binding: MainScreenTestCategoryBlockBinding,
    fingerprints: List<ItemFingerprint<*, *>>,
    viewPool: RecyclerView.RecycledViewPool,
) : BaseViewHolder<MainScreenTestCategoryBlockBinding, TestCategoryBlockItem>(binding) {

    private val fingerprintAdapter = FingerprintAdapter(fingerprints)

    init {
        with(binding.recyclerView) {
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
        recyclerView.restoreState(item.state)
    }

    override fun onViewDetached() {
        binding.recyclerView.onFlingListener = null
        item.state = binding.recyclerView.layoutManager?.onSaveInstanceState() ?: return
    }

    private fun RecyclerView.restoreState(parcelable: Parcelable?) {
        if (parcelable == null) return
        layoutManager?.onRestoreInstanceState(parcelable)
    }

}