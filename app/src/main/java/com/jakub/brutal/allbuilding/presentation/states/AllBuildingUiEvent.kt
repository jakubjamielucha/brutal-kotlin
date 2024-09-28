package com.jakub.brutal.allbuilding.presentation.states

import com.jakub.brutal.allbuilding.domain.models.BuildingDomain

sealed interface AllBuildingUiEvent {
    data object LoadBuildings: AllBuildingUiEvent
    data class OnBuildingClicked(val building: BuildingDomain): AllBuildingUiEvent
}
