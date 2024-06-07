package com.example.brutal.allbuilding.data

import com.example.brutal.core.data.models.BuildingModel

interface AllBuildingRepository {
    suspend fun getAllBuildings(): List<BuildingModel>
}