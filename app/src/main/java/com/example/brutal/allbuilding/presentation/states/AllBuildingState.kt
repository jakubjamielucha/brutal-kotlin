package com.example.brutal.allbuilding.presentation.states

import com.example.brutal.core.data.models.BuildingModel

data class AllBuildingState(
    val buildings: List<BuildingModel> = emptyList(),
    val isLoading: Boolean = false
)
