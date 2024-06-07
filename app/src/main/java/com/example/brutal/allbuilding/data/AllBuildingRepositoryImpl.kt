package com.example.brutal.allbuilding.data

import com.example.brutal.core.data.local.dao.BuildingDao
import com.example.brutal.core.data.models.BuildingModel

class AllBuildingRepositoryImpl(
    private val localSource: BuildingDao
): AllBuildingRepository {
    override suspend fun getAllBuildings(): List<BuildingModel> {
        return localSource.getAll()
    }

}