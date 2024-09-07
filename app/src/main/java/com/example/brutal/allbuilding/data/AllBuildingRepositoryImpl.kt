package com.example.brutal.allbuilding.data

import com.example.brutal.allbuilding.domain.models.BuildingDomain
import com.example.brutal.core.data.local.dao.BuildingDao

class AllBuildingRepositoryImpl(
    private val localSource: BuildingDao
) : AllBuildingRepository {

    override suspend fun getAllBuildings(): List<BuildingDomain> {
        return localSource.getAll().map { BuildingDomain.fromBuildingModel(it) }
    }
}
