package com.example.data.data.mappers

import com.example.data.data.models.names.NamesData
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.names.NamePosterDomain
import com.example.domain.domain.domain.models.names.NamesDomain
import javax.inject.Inject

class NamesDataToDomainMapper @Inject constructor() : Mapper<NamesData, NamesDomain> {
    override fun map(from: NamesData) = from.run {
        NamesDomain(
            id = id,
            name = name,
            image = NamePosterDomain(name = image.name, url = image.url),
        )
    }
}