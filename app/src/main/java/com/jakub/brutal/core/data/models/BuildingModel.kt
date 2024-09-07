package com.jakub.brutal.core.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "brutal")
data class BuildingModel(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int?,

    @ColumnInfo(name = "name")
    val name: String?,

    @ColumnInfo(name = "architect")
    val architect: String?,

    @ColumnInfo(name = "construction_date")
    val constructionDate: String?,

    @ColumnInfo(name = "city")
    val city: String?,

    @ColumnInfo(name = "country")
    val country: String?,

    @ColumnInfo(name = "description")
    val description: String?,

    @ColumnInfo(name = "description_source")
    val descriptionSource: String?,

    @ColumnInfo(name = "maps_coordinates")
    val mapsCoordinates: String?,

    @ColumnInfo(name = "maps_link")
    val mapsLink: String?,

    @ColumnInfo(name = "tags")
    val tags: String?,

    @ColumnInfo(name = "status")
    val status: String?,

    @ColumnInfo(name = "photo_link")
    val photoLink: String?,

    @ColumnInfo(name = "photo_source")
    val photoSource: String?,

    @ColumnInfo(name = "links")
    val links: String?,

    @ColumnInfo(name = "is_favorite")
    val isFavorite: Int?
)
