package com.example.data.cache.mappers

import com.example.data.cache.models.NamesCache
import com.example.data.cache.models.NamesPosterCache
import com.example.data.data.models.names.NamePosterData
import com.example.data.data.models.names.NamesData
import com.example.domain.domain.domain.Mapper
import javax.inject.Inject

class NamesDataToCacheMapper @Inject constructor() : Mapper<NamesData, NamesCache> {
    override fun map(from: NamesData) = from.run {
        NamesCache(
            id = id,
            name = name,
            image = NamesPosterCache(name = image.name, url = image.url)
        )
    }
}

class NamesCacheToDataMapper @Inject constructor() : Mapper<NamesCache, NamesData> {
    override fun map(from: NamesCache) = from.run {
        NamesData(
            id = id,
            name = name,
            image = NamePosterData(name = image.name, url = image.url)
        )
    }
}