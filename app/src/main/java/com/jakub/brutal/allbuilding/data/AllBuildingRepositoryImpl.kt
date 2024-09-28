package com.jakub.brutal.allbuilding.data

import com.jakub.brutal.allbuilding.domain.models.BuildingDomain
import com.jakub.brutal.core.data.local.dao.BuildingDao
import org.koin.core.annotation.Single

@Single(binds = [AllBuildingRepository::class])
class AllBuildingRepositoryImpl(
    private val localSource: BuildingDao
) : AllBuildingRepository {

    override suspend fun getAllBuildings(): List<BuildingDomain> {
        return localSource.getAll().map { BuildingDomain.fromBuildingModel(it) }
    }
}
