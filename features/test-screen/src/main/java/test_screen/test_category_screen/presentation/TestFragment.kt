package test_screen.test_category_screen.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.common_api.base.BaseFragment
import com.example.common_api.base.adapter.FingerprintAdapter
import com.example.common_api.base.adapter.Item
import com.example.test_category.databinding.FragmentTestBinding
import com.example.ui_core.extensions.launchWhenViewStarted
import com.example.utils_core.extensions.setOnDownEffectClickListener
import com.example.utils_core.extensions.setupTextSize
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.filterNotNull
import test_screen.test_category_screen.presentation.adapter.blocks.TestCategoryBlockFingerprint
import test_screen.test_category_screen.presentation.adapter.fingerprints.TestCategoryFingerprint

@AndroidEntryPoint
class TestFragment :
    BaseFragment<FragmentTestBinding, TestViewModel>(FragmentTestBinding::inflate),
    android.widget.SearchView.OnQueryTextListener {

    override val viewModel: TestViewModel by viewModels()

    private val genericAdapter = FingerprintAdapter(
        listOf(

            TestCategoryBlockFingerprint(
                listOf(TestCategoryFingerprint()),
                RecyclerView.RecycledViewPool()
            )
        )
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickers()
        setupRv()
        observeData()
    }

    private fun observeData() = with(viewModel) {
        launchWhenViewStarted {
            allFilteredItemsFlow.filterNotNull().observe(::populateModels)
        }
    }

    private fun setupClickers() = with(binding()) {
        upButton.setOnDownEffectClickListener { viewModel.navigateBack() }
        searchView.setupTextSize()
        searchView.setOnQueryTextListener(this@TestFragment)
        val hint = getString(com.example.ui_core.R.string.The_title_of_the_category)
        searchView.queryHint = hint
        
    }


    private fun populateModels(items: Triple<List<Item>, List<Item>, List<Item>>) {
        genericAdapter.submitList(items.first)
    }

    private fun setupRv() = with(binding()) {
        testRv.adapter = genericAdapter
    }

    override fun onQueryTextSubmit(searchString: String?): Boolean {
        if (searchString != null) viewModel.updateSearchQuery(searchString = searchString)
        return false
    }

    override fun onQueryTextChange(searchString: String?): Boolean {
        if (searchString != null) viewModel.updateSearchQuery(searchString = searchString)
        return false    }
}