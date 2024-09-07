package com.jakub.brutal.allbuilding.presentation.states


data class AllBuildingState(
    val buildings: List<String> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
