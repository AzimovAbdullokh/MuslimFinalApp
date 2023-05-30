package com.example.main_screen.presentation.mappers

import android.annotation.SuppressLint
import com.example.common_api.IdResourceString
import com.example.common_api.Mapper
import com.example.common_api.base.adapter.Item
import com.example.main_screen.domain.models.MainScreenFeatureModuleItems
import com.example.main_screen.domain.models.books.BookMainScreenFeatureModel
import com.example.main_screen.domain.models.khadisses.KhadisFeatureModel
import com.example.main_screen.domain.models.quiz.CategoryMainScreenFeatureDomain
import com.example.main_screen.domain.models.readers.ReadersFeatureMainModel
import com.example.main_screen.domain.models.surah.SurahFeatureModuleDomainModel
import com.example.main_screen.presentation.adapter.items.*
import com.example.main_screen.presentation.listeners.*
import com.example.main_screen.presentation.models.*
import com.example.main_screen.presentation.models.Function
import com.example.main_screen.presentation.models.adapter_models.*
import com.example.ui_core.R
import javax.inject.Inject

interface MainItemsToSearchFilteredFeatureModelMapper {

    fun map(
        items: MainScreenFeatureModuleItems,
        khadisItemOnClickListener: KhadisItemOnClickListener,
        readerItemOnClickListener: ReaderItemOnClickListener,
        mainScreenOpenMoreClickListeners: MainScreenOpenMoreClickListeners,
        bookMainScreenItemOnClickListener: BookMainScreenItemOnClickListener,
        communityItemClickListener: CommunityItemClickListener,
        cardItemClickListener: MainCardItemClickListener,
        quizCategoryItemClickListener: QuizCategoryItemClickListener,
    ): Triple<List<Item>, List<Item>, List<Item>>
}


class MainItemsToSearchFilteredFeatureModelMapperImpl @Inject constructor(
    private val khadisFeatureModelToUiMapper: Mapper<KhadisFeatureModel, KhadissesFeatureUi>,
    private val readerFeatureModelToUiMapper: Mapper<ReadersFeatureMainModel, ReadersFeatureMainUiModel>,
    private val bookFeatureModelToUiMapper: Mapper<BookMainScreenFeatureModel, BooksMainScreenFeatureModelUi>,
    private val quizCategoryFeatureDomainToUiMapper: Mapper<CategoryMainScreenFeatureDomain, CategoryMainScreenFeatureUi>,
) : MainItemsToSearchFilteredFeatureModelMapper {
    private companion object {
        const val MAX_ITEMS_SHOW_COUNT_IN_MAIN_SCREEN = 10
    }


    @SuppressLint("SuspiciousIndentation")
    override fun map(
        items: MainScreenFeatureModuleItems,
        khadisItemOnClickListener: KhadisItemOnClickListener,
        readerItemOnClickListener: ReaderItemOnClickListener,
        mainScreenOpenMoreClickListeners: MainScreenOpenMoreClickListeners,
        bookMainScreenItemOnClickListener: BookMainScreenItemOnClickListener,
        communityItemClickListener: CommunityItemClickListener,
        cardItemClickListener: MainCardItemClickListener,
        quizCategoryItemClickListener: QuizCategoryItemClickListener,
    ): Triple<List<Item>, List<Item>, List<Item>> {

        val filteredQuizCategoriesList =
            items.categories.map(quizCategoryFeatureDomainToUiMapper::map).map {
                CategoryFeatureAdapterModel(testCategories = CategoryMainScreenFeatureUi(
                    id = it.id,
                    titles = it.titles,
                    descriptions = it.descriptions,
                    poster = it.poster,
                    type = it.type),
                    listener = quizCategoryItemClickListener
                )
            }.take(MAX_ITEMS_SHOW_COUNT_IN_MAIN_SCREEN)

        val filteredBooksList = items.books.map(bookFeatureModelToUiMapper::map).map {
            BookMainScreenAdapterModel(
                bookTitle = it.bookTitle,
                bookAuthor = it.bookAuthor,
                id = it.id,
                createdAt = it.createdAt,
                bookDescription = it.bookDescription,
                posterUrl = it.poster.url,
                listener = bookMainScreenItemOnClickListener,
                pages = it.pages,
                publicYear = it.publicYear,
                format = it.bookFormat
            )
        }.take(MAX_ITEMS_SHOW_COUNT_IN_MAIN_SCREEN)


        val filteredKhadissesList = items.khadisses.map(khadisFeatureModelToUiMapper::map).map {
            KhadisAdapterModel(id = it.id,
                title = it.title,
                createdAt = it.createdAt,
                khadisId = it.khadisId,
                khadisDescription = it.khadisDescription,
                khadisSubject = it.khadisSubject,
                listener = khadisItemOnClickListener,
                namazImageUrl = it.namzImage.url)
        }.take(MAX_ITEMS_SHOW_COUNT_IN_MAIN_SCREEN)


        val filteredReadersList = items.readers.map(readerFeatureModelToUiMapper::map).map {
            ReadersMainAdapterModel(id = it.id,
                readerId = it.readerId,
                readerName = it.readerName,
                posterUrl = it.readerPoster.url,
                listener = readerItemOnClickListener)
        }.take(MAX_ITEMS_SHOW_COUNT_IN_MAIN_SCREEN)

        val filteredFuntionsList = Function.fetchAllFunctions().map {
            CommunityItem(community = it, listener = communityItemClickListener)
        }

        val allItems = mutableListOf<Item>()

        val readerItem = MainFeatureScreenReadersBlockItem(filteredReadersList)
        if (readerItem.items.isNotEmpty()) allItems.addAll(listOf(readerItem))

        val functionItem = MainScreenCommunityBlockItem(filteredFuntionsList)
        allItems.add(createHeaderModelForAllFunctions{})
        allItems.addAll(listOf(functionItem))

        val khadisItem = MainScreenKhadissesBlockItem(filteredKhadissesList)
        if (khadisItem.items.isNotEmpty()) allItems.add(createHeaderModelForAllKhadisses { })
        allItems.addAll(listOf(khadisItem))

        val bookItem = MainScreenBooksBlockItem(filteredBooksList)
        if (bookItem.items.isNotEmpty()) allItems.add(createHeaderModelForAllBooks { mainScreenOpenMoreClickListeners.navigateToBooksFragment() })
        allItems.addAll(listOf(bookItem))

        val quizCategoryItem = TestCategoryBlockItem(filteredQuizCategoriesList)
        if (quizCategoryItem.items.isNotEmpty()) allItems.add(createHeaderModelForAllQuizCategories {})
        allItems.addAll(listOf(quizCategoryItem))


        val allScreenItems = mutableListOf<Item>()

        val allBookScreenItem = MainScreenBooksBlockItem(filteredBooksList)
        if (allBookScreenItem.items.isNotEmpty())
            allScreenItems.addAll(listOf(allBookScreenItem))

        return Triple(allItems, allScreenItems, emptyList())
    }


    private fun createHeaderModelForAllQuizCategories(navigateToAllQuizCategoriesFragment: () -> Unit) =
        HeaderItem(
            titleId = IdResourceString(R.string.quiz_categories),
            onClickListener = { navigateToAllQuizCategoriesFragment() })

    private fun createHeaderModelForAllBooks(navigateToAllBooksFragment: () -> Unit) = HeaderItem(
        titleId = IdResourceString(com.example.ui_core.R.string.islamicBooks),
        onClickListener = { navigateToAllBooksFragment() },
        showMoreIsVisible = true,
    )

    private fun createHeaderModelForAllKhadisses(navigateToAllBooksFragment: () -> Unit) =
        HeaderItem(
            titleId = IdResourceString(R.string.namazes),
            onClickListener = { navigateToAllBooksFragment() },
        )

    private fun createHeaderModelForAllFunctions(navigateToAllBooksFragment: () -> Unit) = HeaderItem(
        titleId = IdResourceString(R.string.gunctions),
        onClickListener = { navigateToAllBooksFragment() })

    private fun createHeaderModelForAllSurah(navigateToAllBooksFragment: () -> Unit) = HeaderItem(
        titleId = IdResourceString(R.string.surah),
        onClickListener = { navigateToAllBooksFragment() },
    )


}