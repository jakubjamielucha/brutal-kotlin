package com.example.brutal.core.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("brutal")
data class BuildingModel(
    @PrimaryKey val id: String,
    val name: String,
    val architect: String,
    @ColumnInfo(name = "construction_date") val constructionDate: String,
    val city: String,
    val country: String,
    val description: String,
    @ColumnInfo(name = "description_source") val descriptionSource: String,
    @ColumnInfo(name = "maps_coordinates") val mapsCoordinates: String,
    @ColumnInfo(name = "maps_link") val mapsLink: String,
    val tags: String,
    val status: String,
    @ColumnInfo(name = "photo_link") val photoLink: String,
    @ColumnInfo(name = "photo_source") val photoSource: String,
    val links: String,
    @ColumnInfo(name = "is_favorite") val isFavorite: Boolean
)
