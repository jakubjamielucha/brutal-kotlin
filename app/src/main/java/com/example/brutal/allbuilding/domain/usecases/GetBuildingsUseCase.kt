package com.example.brutal.allbuilding.domain.usecases

import com.example.brutal.allbuilding.data.AllBuildingRepository
import com.example.brutal.core.data.local.dao.BuildingDao
import com.example.brutal.core.data.models.BuildingModel

class GetBuildingsUseCase(
    private val allBuildingRepository: AllBuildingRepository
) {
    suspend operator fun invoke(): List<BuildingModel> {
        return allBuildingRepository.getAllBuildings()
    }
}