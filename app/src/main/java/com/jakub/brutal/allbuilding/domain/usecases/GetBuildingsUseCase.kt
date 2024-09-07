package com.jakub.brutal.allbuilding.domain.usecases

import com.jakub.brutal.allbuilding.data.AllBuildingRepository

class GetBuildingsUseCase(
    private val allBuildingRepository: AllBuildingRepository
) {
    suspend operator fun invoke(): List<String> {
        return allBuildingRepository.getAllBuildings().map { it.name }
    }
}