package com.jakub.brutal.allbuilding.domain.usecases

import com.jakub.brutal.allbuilding.data.AllBuildingRepository
import com.jakub.brutal.allbuilding.domain.models.BuildingDomain
import org.koin.core.annotation.Single

@Single
class GetBuildingsUseCase(
    private val allBuildingRepository: AllBuildingRepository
) {
    suspend operator fun invoke(): List<BuildingDomain> {
        return allBuildingRepository.getAllBuildings()
    }
}