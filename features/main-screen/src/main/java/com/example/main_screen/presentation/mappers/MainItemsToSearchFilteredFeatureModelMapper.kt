package com.example.main_screen.presentation.mappers

import android.annotation.SuppressLint
import com.example.common_api.IdResourceString
import com.example.common_api.Mapper
import com.example.common_api.base.adapter.Item
import com.example.main_screen.domain.models.MainScreenFeatureModuleItems
import com.example.main_screen.domain.models.books.BookFeatureModel
import com.example.main_screen.domain.models.khadisses.KhadisFeatureModel
import com.example.main_screen.domain.models.nasheeds.NasheedsFeatureModel
import com.example.main_screen.domain.models.readers.ReadersFeatureModel
import com.example.main_screen.domain.models.surah.SurahFeatureModuleDomainModel
import com.example.main_screen.presentation.adapter.items.*
import com.example.main_screen.presentation.listeners.*
import com.example.main_screen.presentation.models.*
import com.example.main_screen.presentation.models.adapter_models.*
import com.example.ui_core.R
import javax.inject.Inject

interface MainItemsToSearchFilteredFeatureModelMapper {

    fun map(
        items: MainScreenFeatureModuleItems,
//        bookItemOnClickListener: BookItemOnClickListener,
        audioNasheedItemOnClickListener: NasheedItemOnClickListener,
//        khadisItemOnClickListener: KhadisItemOnClickListener,
//        readerItemOnClickListener: ReaderItemOnClickListener,
//        surahItemOnClickListener: SurahItemOnClickListener,
        communityItemClickListener: CommunityItemClickListener,
        cardItemClickListener: MainCardItemClickListener
    ): Triple<List<Item>, List<Item>, List<Item>>
}


class MainItemsToSearchFilteredFeatureModelMapperImpl @Inject constructor(
    private val bookFeatureModelToUiMapper: Mapper<BookFeatureModel, BooksFeatureModelUi>,
    private val nasheedFeatureModelToUiMapper: Mapper<NasheedsFeatureModel, AudioNasheedsUi>,
    private val khadisFeatureModelToUiMapper: Mapper<KhadisFeatureModel, KhadissesFeatureUi>,
    private val readerFeatureModelToUiMapper: Mapper<ReadersFeatureModel, ReadersFeatureUiModel>,
    private val surahFeatureModelToUiMapper: Mapper<SurahFeatureModuleDomainModel, SurahFeatureUiModel>,
) : MainItemsToSearchFilteredFeatureModelMapper {
    private companion object {
        const val MAX_ITEMS_SHOW_COUNT_IN_MAIN_SCREEN = 10
        const val MAX_SURAH_SHOW_COUNT_IN_MAIN_SCREEN = 114
    }

    @SuppressLint("SuspiciousIndentation")
    override fun map(
        items: MainScreenFeatureModuleItems,
//        bookItemOnClickListener: BookItemOnClickListener,
        audioNasheedItemOnClickListener: NasheedItemOnClickListener,
//        khadisItemOnClickListener: KhadisItemOnClickListener,
//        readerItemOnClickListener: ReaderItemOnClickListener,
//        surahItemOnClickListener: SurahItemOnClickListener,
        communityItemClickListener: CommunityItemClickListener,
        cardItemClickListener: MainCardItemClickListener
    ): Triple<List<Item>, List<Item>, List<Item>> {

//        val filteredBooksList = items.books.map(bookFeatureModelToUiMapper::map).map {
//            BookAdapterModel(bookTitle = it.bookTitle,
//                bookAuthor = it.bookAuthor,
//                id = it.id,
//                createdAt = it.createdAt,
//                bookDescription = it.bookDescription,
//                posterUrl = it.poster.url,
//                listener = bookItemOnClickListener)
//        }.take(MAX_ITEMS_SHOW_COUNT_IN_MAIN_SCREEN)


        val filteredAudioNasheedList =
            items.audioNasheeds.map(nasheedFeatureModelToUiMapper::map).map {
                AudioNasheedAdapterModel(audioNasheeds = AudioNasheedsUi(id = it.id,
                    title = it.title,
                    createdAt = it.createdAt,
                    nasheedFile = it.nasheedFile,
                    nasheedPoster = it.nasheedPoster,
                    currentStartPosition = it.currentStartPosition,
                    audioId = it.audioId), listener = audioNasheedItemOnClickListener)
            }.take(MAX_ITEMS_SHOW_COUNT_IN_MAIN_SCREEN)


//        val filteredKhadissesList = items.khadisses.map(khadisFeatureModelToUiMapper::map).map {
//            KhadisAdapterModel(id = it.id,
//                title = it.title,
//                createdAt = it.createdAt,
//                khadisId = it.khadisId,
//                khadisDescription = it.khadisDescription,
//                khadisSubject = it.khadisSubject,
//                listener = khadisItemOnClickListener)
//        }.take(MAX_ITEMS_SHOW_COUNT_IN_MAIN_SCREEN)


//        val filteredReadersList = items.readers.map(readerFeatureModelToUiMapper::map).map {
//            ReadersAdapterModel(
//                id = it.id,
//                readerId = it.readerId,
//                readerName = it.readerName,
//                posterUrl = it.readerPoster.url,
//                listener = readerItemOnClickListener
//            )
//        }.take(MAX_ITEMS_SHOW_COUNT_IN_MAIN_SCREEN)
//
//        val filteredSurahList = items.surah.map(surahFeatureModelToUiMapper::map).map {
//            SurahAdapterModel(
//                id = it.id,
//                surahId = it.surahId,
//                surahName = it.surahName,
//                surahArabName = it.surahArabName,
//                surahCountInQuran = it.surahCountInQuran,
//                listener = surahItemOnClickListener
//            )
//        }.take(MAX_SURAH_SHOW_COUNT_IN_MAIN_SCREEN)

        val allCommunity = Community.fetchAllCommunities().map {
            CommunityItem(community = it, listener = communityItemClickListener)
        }

        val allItems = mutableListOf<Item>()

        val mainCardItem = MainCardItem(cardItemClickListener)
        allItems.addAll(listOf(mainCardItem))

//        val readerItem = MainScreenReadersBlockItem(filteredReadersList)
//        if (readerItem.items.isNotEmpty()) allItems.add(createHeaderModelForAllReaders {})
//        allItems.addAll(listOf(readerItem))

        val audioNasheedItem = MainScreenAudioNasheedsBlockItem(filteredAudioNasheedList)
        if (audioNasheedItem.items.isNotEmpty()) allItems.add(
            createHeaderModelForAllAudioNasheeds { })
        allItems.addAll(listOf(audioNasheedItem))

        val communityItem = MainScreenCommunityBlockItem(allCommunity)
        allItems.addAll(listOf(communityItem))
//
//        val surahItem = MainScreenSurahBlockItem(filteredSurahList)
//        if (surahItem.items.isNotEmpty()) allItems.add(createHeaderModelForAllSurah {})
//        allItems.addAll(listOf(surahItem))
//
//        val bookItem = MainScreenBooksBlockItem(filteredBooksList)
//        if (bookItem.items.isNotEmpty()) allItems.add(createHeaderModelForAllBooks { })
//        allItems.addAll(listOf(bookItem))
//
//
//        val khadisItem = MainScreenKhadissesBlockItem(filteredKhadissesList)
//        if (khadisItem.items.isNotEmpty()) allItems.add(
//            createHeaderModelForAllKhadisses { })
//        allItems.addAll(listOf(khadisItem))

        return Triple(allItems, emptyList(), emptyList())
    }


    private fun createHeaderModelForAllAudioNasheeds(navigateToAllAudioBooksFragment: () -> Unit) =
        HeaderItem(titleId = IdResourceString(R.string.nasheeds),
            onClickListener = { navigateToAllAudioBooksFragment() })

    private fun createHeaderModelForAllBooks(navigateToAllBooksFragment: () -> Unit) = HeaderItem(
        titleId = IdResourceString(com.example.ui_core.R.string.islamicBooks),
        onClickListener = { navigateToAllBooksFragment() })

    private fun createHeaderModelForAllKhadisses(navigateToAllBooksFragment: () -> Unit) =
        HeaderItem(titleId = IdResourceString(com.example.ui_core.R.string.khadisses),
            onClickListener = { navigateToAllBooksFragment() })

    private fun createHeaderModelForAllReaders(navigateToAllBooksFragment: () -> Unit) =
        HeaderItem(titleId = IdResourceString(R.string.readers),
            onClickListener = { navigateToAllBooksFragment() })

    private fun createHeaderModelForAllSurah(navigateToAllBooksFragment: () -> Unit) =
        HeaderItem(
            titleId = IdResourceString(R.string.surah),
            onClickListener = { navigateToAllBooksFragment() },
        )


}