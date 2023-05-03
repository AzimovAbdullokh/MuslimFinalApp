package com.example.alarms.presentation.audio_screen.mappers

import android.annotation.SuppressLint
import com.example.alarms.domain.models.MainNasheedItems
import com.example.alarms.domain.models.nasheeds.NasheedsFeatureModel
import com.example.alarms.presentation.audio_screen.adapter.items.HeaderItem
import com.example.alarms.presentation.audio_screen.adapter.items.MainScreenAudioNasheedsBlockItem
import com.example.alarms.presentation.audio_screen.listeners.NasheedItemOnClickListener
import com.example.alarms.presentation.audio_screen.models.AudioNasheedAdapterModel
import com.example.alarms.presentation.audio_screen.models.AudioNasheedsUi
import com.example.common_api.IdResourceString
import com.example.common_api.Mapper
import com.example.common_api.base.adapter.Item
import com.example.ui_core.R
import javax.inject.Inject

interface MainNasheedFilteredItemsMapper {

    fun map(
        items: MainNasheedItems,
        nasheedsItemOnClickListener: NasheedItemOnClickListener,
    ): Triple<List<Item>, List<Item>, List<Item>>
}

class MainNasheedFilteredItemsMapperImpl @Inject constructor(
    private val nasheedFeatureModelToUiMapper: Mapper<NasheedsFeatureModel, AudioNasheedsUi>,
) : MainNasheedFilteredItemsMapper {
    private companion object {
        const val MAX_ITEMS_SHOW_COUNT_IN_MAIN_SCREEN = 10
    }

    @SuppressLint("SuspiciousIndentation")
    override fun map(
        items: MainNasheedItems,
        nasheedItemOnClickListener: NasheedItemOnClickListener,
    ): Triple<List<Item>, List<Item>, List<Item>> {

        val filteredAudioNasheedList = items.nasheeds.map(nasheedFeatureModelToUiMapper::map).map {
            AudioNasheedAdapterModel(audioNasheeds = AudioNasheedsUi(id = it.id,
                title = it.title,
                createdAt = it.createdAt,
                nasheedFile = it.nasheedFile,
                nasheedPoster = it.nasheedPoster,
                currentStartPosition = it.currentStartPosition,
                audioId = it.audioId), listener = nasheedItemOnClickListener)
        }.take(MAX_ITEMS_SHOW_COUNT_IN_MAIN_SCREEN)


        val allItems = mutableListOf<Item>()

        val audioNasheedItem = MainScreenAudioNasheedsBlockItem(filteredAudioNasheedList)
        if (audioNasheedItem.items.isNotEmpty())
        allItems.addAll(listOf(audioNasheedItem))

        return Triple(allItems, emptyList(), emptyList())

    }

    private fun createHeaderModelForAllAudioNasheeds(navigateToAllAudioBooksFragment: () -> Unit) =
        HeaderItem(titleId = IdResourceString(R.string.nasheeds),
            onClickListener = { navigateToAllAudioBooksFragment() })

}