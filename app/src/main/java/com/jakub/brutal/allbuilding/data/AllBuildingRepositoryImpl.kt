package com.jakub.brutal.allbuilding.data

import com.jakub.brutal.allbuilding.domain.models.BuildingDomain
import com.jakub.brutal.core.data.local.dao.BuildingDao

class AllBuildingRepositoryImpl(
    private val localSource: BuildingDao
) : AllBuildingRepository {

    override suspend fun getAllBuildings(): List<BuildingDomain> {
        return localSource.getAll().map { BuildingDomain.fromBuildingModel(it) }
    }
}
