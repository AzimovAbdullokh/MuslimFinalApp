package com.example.main_quran.presentation.mappers

import com.example.common_api.Mapper
import com.example.common_api.base.adapter.Item
import com.example.main_quran.domain.models.MainQuranItems
import com.example.main_quran.domain.models.QuranFeatureModuleDomainModel
import com.example.main_quran.presentation.adapter.items.MainScreenQuranBlockItem
import com.example.main_quran.presentation.listener.QuranItemOnClickListener
import com.example.main_quran.presentation.models.QuranAdapterModel
import com.example.main_quran.presentation.models.QuranFeatureUiModel
import javax.inject.Inject

interface MainQuranFilteredItemsMapper {

    fun map(
        items: MainQuranItems,
        quranItemOnClickListener: QuranItemOnClickListener,
        searchQuery: String,
    ): Triple<List<Item>, List<Item>, List<Item>>
}

class MainQuranFilteredItemsMapperImpl @Inject constructor(
    private val quranFeatureDomainModelToUiMapper: Mapper<QuranFeatureModuleDomainModel, QuranFeatureUiModel>,

    ) : MainQuranFilteredItemsMapper {
    private companion object {
        const val MAX_ITEMS_SHOW_COUNT_IN_MAIN_SCREEN = 114
    }

    override fun map(
        items: MainQuranItems,
        quranItemOnClickListener: QuranItemOnClickListener,
        searchQuery: String,
    ): Triple<List<Item>, List<Item>, List<Item>> {


        val filteredQuranList = items.qurans.map(quranFeatureDomainModelToUiMapper::map)
            .filter { applyFilterForAllSurah(it, searchQuery = searchQuery) }
            .map {
                QuranAdapterModel(
                    id = it.id,
                    surahId = it.surahId,
                    surahName = it.surahName,
                    surahArabName = it.surahArabName,
                    surahCountInQuran = it.surahCountInQuran,
                    listener = quranItemOnClickListener
                )
            }.take(MAX_ITEMS_SHOW_COUNT_IN_MAIN_SCREEN)

        val allItems = mutableListOf<Item>()

        val quranItem = MainScreenQuranBlockItem(filteredQuranList)
        if (quranItem.items.isNotEmpty()) allItems.addAll(listOf(quranItem))

        return Triple(allItems, emptyList(), emptyList())
    }

    private fun applyFilterForAllSurah(quran: QuranFeatureUiModel, searchQuery: String) =
        if (searchQuery.isEmpty()) quran.surahName != String()
        else quran.surahName.contains(searchQuery, ignoreCase = true)


}