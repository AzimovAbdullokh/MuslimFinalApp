package com.example.alarms.presentation.audio_screen.mappers

import android.annotation.SuppressLint
import com.example.alarms.domain.models.MainNasheedItems
import com.example.alarms.domain.models.books.BookFeatureModel
import com.example.alarms.domain.models.nasheeds.NasheedsFeatureModel
import com.example.alarms.domain.models.readers.ReadersFeatureModel
import com.example.alarms.presentation.audio_screen.adapter.items.HeaderItem
import com.example.alarms.presentation.audio_screen.adapter.items.MainScreenAudioNasheedsBlockItem
import com.example.alarms.presentation.audio_screen.adapter.items.MainScreenBooksBlockItem
import com.example.alarms.presentation.audio_screen.adapter.items.MainScreenReadersBlockItem
import com.example.alarms.presentation.audio_screen.listeners.BookItemOnClickListener
import com.example.alarms.presentation.audio_screen.listeners.NasheedItemOnClickListener
import com.example.alarms.presentation.audio_screen.listeners.ReaderItemOnClickListener
import com.example.alarms.presentation.audio_screen.models.AudioNasheedsUi
import com.example.alarms.presentation.audio_screen.models.BooksFeatureModelUi
import com.example.alarms.presentation.audio_screen.models.ReadersFeatureUiModel
import com.example.alarms.presentation.audio_screen.models.adapter_models.AudioNasheedAdapterModel
import com.example.alarms.presentation.audio_screen.models.adapter_models.BookAdapterModel
import com.example.alarms.presentation.audio_screen.models.adapter_models.ReadersAdapterModel
import com.example.common_api.IdResourceString
import com.example.common_api.Mapper
import com.example.common_api.base.adapter.Item
import com.example.ui_core.R
import javax.inject.Inject

interface MainNasheedFilteredItemsMapper {

    fun map(
        items: MainNasheedItems,
        nasheedsItemOnClickListener: NasheedItemOnClickListener,
        bookItemOnClickListener: BookItemOnClickListener,
        readerItemOnClickListener: ReaderItemOnClickListener,
    ): Triple<List<Item>, List<Item>, List<Item>>
}

class MainNasheedFilteredItemsMapperImpl @Inject constructor(
    private val nasheedFeatureModelToUiMapper: Mapper<NasheedsFeatureModel, AudioNasheedsUi>,
    private val bookFeatureModelToUiMapper: Mapper<BookFeatureModel, BooksFeatureModelUi>,
    private val readerFeatureModelToUiMapper: Mapper<ReadersFeatureModel, ReadersFeatureUiModel>,
) : MainNasheedFilteredItemsMapper {
    private companion object {
        const val MAX_ITEMS_SHOW_COUNT_IN_MAIN_SCREEN = 10
    }

    @SuppressLint("SuspiciousIndentation")
    override fun map(
        items: MainNasheedItems,
        nasheedsItemOnClickListener: NasheedItemOnClickListener,
        bookItemOnClickListener: BookItemOnClickListener,
        readerItemOnClickListener: ReaderItemOnClickListener,
    ): Triple<List<Item>, List<Item>, List<Item>> {

        val filteredAudioNasheedList = items.nasheeds.map(nasheedFeatureModelToUiMapper::map).map {
            AudioNasheedAdapterModel(audioNasheeds = AudioNasheedsUi(id = it.id,
                title = it.title,
                createdAt = it.createdAt,
                nasheedFile = it.nasheedFile,
                nasheedPoster = it.nasheedPoster,
                currentStartPosition = it.currentStartPosition,
                audioId = it.audioId), listener = nasheedsItemOnClickListener)
        }.take(MAX_ITEMS_SHOW_COUNT_IN_MAIN_SCREEN)

        val filteredBooksList = items.books.map(bookFeatureModelToUiMapper::map).map {
            BookAdapterModel(bookTitle = it.bookTitle,
                bookAuthor = it.bookAuthor,
                id = it.id,
                createdAt = it.createdAt,
                bookDescription = it.bookDescription,
                posterUrl = it.poster.url,
                listener = bookItemOnClickListener)
        }.take(MAX_ITEMS_SHOW_COUNT_IN_MAIN_SCREEN)

        val filteredReadersList = items.readers.map(readerFeatureModelToUiMapper::map).map {
            ReadersAdapterModel(id = it.id,
                readerId = it.readerId,
                readerName = it.readerName,
                posterUrl = it.readerPoster.url,
                listener = readerItemOnClickListener)
        }.take(MAX_ITEMS_SHOW_COUNT_IN_MAIN_SCREEN)

        val allItems = mutableListOf<Item>()

        val readerItem = MainScreenReadersBlockItem(filteredReadersList)
        if (readerItem.items.isNotEmpty()) allItems.add(createHeaderModelForAllReaders {})
        allItems.addAll(listOf(readerItem))

        val audioNasheedItem = MainScreenAudioNasheedsBlockItem(filteredAudioNasheedList)
        if (audioNasheedItem.items.isNotEmpty()) allItems.add(createHeaderModelForAllAudioNasheeds())
        allItems.addAll(listOf(audioNasheedItem))

        val bookItem = MainScreenBooksBlockItem(filteredBooksList)
        if (bookItem.items.isNotEmpty()) allItems.add(createHeaderModelForAllBooks { })
        allItems.addAll(listOf(bookItem))

        val nasheedsForPager = mutableListOf<Item>()

        val audioNasheedItemForPager = MainScreenAudioNasheedsBlockItem(filteredAudioNasheedList)
        if (audioNasheedItemForPager.items.isNotEmpty()) nasheedsForPager.addAll(listOf(
            audioNasheedItemForPager))

        return Triple(allItems, nasheedsForPager, emptyList())

    }

    private fun createHeaderModelForAllAudioNasheeds() =
        HeaderItem(titleId = IdResourceString(R.string.nasheeds), onClickListener = { })

    private fun createHeaderModelForAllBooks(navigateToAllBooksFragment: () -> Unit) = HeaderItem(
        titleId = IdResourceString(com.example.ui_core.R.string.islamicBooks),
        onClickListener = { navigateToAllBooksFragment() })

    private fun createHeaderModelForAllReaders(navigateToAllBooksFragment: () -> Unit) =
        HeaderItem(titleId = IdResourceString(R.string.readers),
            onClickListener = { navigateToAllBooksFragment() })
}