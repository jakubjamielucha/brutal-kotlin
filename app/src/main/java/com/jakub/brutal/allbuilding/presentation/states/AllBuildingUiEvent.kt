package com.jakub.brutal.allbuilding.presentation.states

sealed interface AllBuildingUiEvent {
    data object LoadBuildings: AllBuildingUiEvent
}
