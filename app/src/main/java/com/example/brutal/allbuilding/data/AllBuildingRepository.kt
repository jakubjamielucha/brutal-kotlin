package com.example.brutal.allbuilding.data

import com.example.brutal.allbuilding.domain.models.BuildingDomain
import com.example.brutal.core.data.models.TestModel

interface AllBuildingRepository {
    suspend fun getAllBuildings(): List<BuildingDomain>
}