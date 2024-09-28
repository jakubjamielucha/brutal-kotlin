package com.jakub.brutal.allbuilding.presentation.states

import com.jakub.brutal.allbuilding.domain.models.BuildingDomain


data class AllBuildingUiState(
    val buildings: List<BuildingDomain> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
