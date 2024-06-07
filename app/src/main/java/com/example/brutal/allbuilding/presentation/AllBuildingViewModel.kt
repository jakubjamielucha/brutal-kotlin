package com.example.brutal.allbuilding.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brutal.allbuilding.domain.usecases.GetBuildingsUseCase
import com.example.brutal.allbuilding.presentation.states.AllBuildingState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AllBuildingViewModel(
    private val useCase: GetBuildingsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(AllBuildingState())
    val uiState get() = _uiState.asStateFlow()

    fun getAllBuilding() = viewModelScope.launch(Dispatchers.IO) {
        _uiState.update { it.copy(isLoading = true) }
        val buildings = useCase.invoke()
        _uiState.update { it.copy(isLoading = false, buildings = buildings) }
    }
}