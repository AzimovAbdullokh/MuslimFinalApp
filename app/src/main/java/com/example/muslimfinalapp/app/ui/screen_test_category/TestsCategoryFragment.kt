package com.example.muslimfinalapp.app.ui.screen_test_category

import com.example.book_info.presentation.ui.BookInfoFragmentArgs

//@AndroidEntryPoint
//class TestsCategoryFragment :
//    BaseFragment<FragmentTestsCategoryBinding, TestsCategoryViewModel>(FragmentTestsCategoryBinding::inflate) {
//
//    override val viewModel: TestsCategoryViewModel by viewModels()
//
//    private val bookId: String by lazy(LazyThreadSafetyMode.NONE) {
//        BookInfoFragmentArgs.fromBundle(requireArguments()).id
//    }
//
//
//    private val fingerprintAdapter = FingerprintAdapter(
//        listOf(BookGenreFingerprint())
//    )
//
//    var concatAdapter: ConcatAdapter = ConcatAdapter(
//        ConcatAdapter.Config.Builder().setIsolateViewTypes(false).build(),
//        fingerprintAdapter,
//    )
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        setupRv()
//        observeRecourse()
//    }
//
//    private fun observeRecourse() = with(viewModel) {
//        launchWhenViewStarted {
//            allCategoriesFlow.filter { it.isNotEmpty() }.observe(::populateModels)
//        }
//    }
//
//    private fun populateModels(items: List<Item>) {
////        saveRecyclerViewCurrentState()
//        fingerprintAdapter.submitList(items) { }
//    }
//
//    private fun setupRv() {
//        binding().categoryRv.adapter = concatAdapter
//    }
//}