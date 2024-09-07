package com.jakub.brutal.allbuilding.data

import com.jakub.brutal.allbuilding.domain.models.BuildingDomain

interface AllBuildingRepository {
    suspend fun getAllBuildings(): List<BuildingDomain>
}