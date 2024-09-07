package com.jakub.brutal.allbuilding.domain.models

import com.jakub.brutal.core.data.models.BuildingModel

data class BuildingDomain(
    val id: Int,
    val name: String,
    val architect: String,
    val constructionDate: String,
    val city: String,
    val country: String,
    val description: String,
    val descriptionSource: String,
    val mapsCoordinates: String,
    val mapsLink: String,
    val tags: String,
    val status: String,
    val photoLink: String,
    val photoSource: String,
    val links: String,
    val isFavorite: Boolean
) {
    constructor(
        id: Int = 0,
        name: String? = null,
        architect: String? = null,
        constructionDate: String? = null,
        city: String? = null,
        country: String? = null,
        description: String? = null,
        descriptionSource: String? = null,
        mapsCoordinates: String? = null,
        mapsLink: String? = null,
        tags: String? = null,
        status: String? = null,
        photoLink: String? = null,
        photoSource: String? = null,
        links: String? = null,
        isFavorite: Int? = null
    ) : this(
        id = id,
        name = name ?: "",
        architect = architect ?: "",
        constructionDate = constructionDate ?: "",
        city = city ?: "",
        country = country ?: "",
        description = description ?: "",
        descriptionSource = descriptionSource ?: "",
        mapsCoordinates = mapsCoordinates ?: "",
        tags = tags ?: "",
        status = status ?: "",
        mapsLink = mapsLink ?: "",
        photoLink = photoLink ?: "",
        photoSource = photoSource ?: "",
        links = links ?: "",
        isFavorite = isFavorite != 0
    )

    companion object {
        fun fromBuildingModel(buildingModel: BuildingModel): BuildingDomain {
            return BuildingDomain(
                id = buildingModel.id ?: 0,
                name = buildingModel.name,
                architect = buildingModel.architect,
                constructionDate = buildingModel.constructionDate,
                city = buildingModel.city,
                country = buildingModel.country,
                description = buildingModel.description,
                descriptionSource = buildingModel.descriptionSource,
                mapsCoordinates = buildingModel.mapsCoordinates,
                mapsLink = buildingModel.mapsLink,
                tags = buildingModel.tags,
                status = buildingModel.status,
                photoLink = buildingModel.photoLink,
                photoSource = buildingModel.photoSource,
                links = buildingModel.links,
                isFavorite = buildingModel.isFavorite
            )
        }
    }

    fun toBuildingModel(): BuildingModel {
        return BuildingModel(
            id = id,
            name = name,
            architect = architect,
            constructionDate = constructionDate,
            city = city,
            country = country,
            description = description,
            descriptionSource = descriptionSource,
            mapsCoordinates = mapsCoordinates,
            mapsLink = mapsLink,
            tags = tags,
            status = status,
            photoLink = photoLink,
            photoSource = photoSource,
            links = links,
            isFavorite = if (isFavorite) 1 else 0
        )
    }
}