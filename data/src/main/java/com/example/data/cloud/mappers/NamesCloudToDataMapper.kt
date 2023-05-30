package com.example.data.cloud.mappers

import com.example.data.cloud.models.names.NamesCloud
import com.example.data.data.models.names.NamePosterData
import com.example.data.data.models.names.NamesData
import com.example.domain.domain.domain.Mapper
import javax.inject.Inject

class NamesCloudToDataMapper @Inject constructor() : Mapper<NamesCloud, NamesData> {
    override fun map(from: NamesCloud) = from.run {
        NamesData(
            id = id,
            name = name,
            image = NamePosterData(name = image.name, url = image.url)
        )
    }
}