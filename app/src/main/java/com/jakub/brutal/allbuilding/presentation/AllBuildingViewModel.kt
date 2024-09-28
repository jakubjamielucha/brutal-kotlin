package com.jakub.brutal.allbuilding.presentation

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.jakub.brutal.allbuilding.domain.usecases.GetBuildingsUseCase
import com.jakub.brutal.allbuilding.presentation.states.AllBuildingUiEvent
import com.jakub.brutal.allbuilding.presentation.states.AllBuildingUiState
import com.jakub.brutal.core.presentation.BaseViewModel
import com.jakub.brutal.core.presentation.utils.safeLaunch
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class AllBuildingViewModel(
    private val useCase: GetBuildingsUseCase,
) : BaseViewModel<AllBuildingUiState, AllBuildingUiEvent>(AllBuildingUiState()) {

    override fun onUiStateSubscribed() {
        super.onUiStateSubscribed()
        onEvent(AllBuildingUiEvent.LoadBuildings)
    }

    override fun onEventSideEffect(event: AllBuildingUiEvent) {
        when (event) {
            AllBuildingUiEvent.LoadBuildings -> getAllBuilding()
            else -> Unit
        }
    }

    private fun getAllBuilding() {
        _uiState.update { it.copy(isLoading = true) }
        viewModelScope.safeLaunch(
            context = ioDispatcher,
            onError = { exception ->
                _uiState.update { it.copy(isLoading = false, errorMessage = exception.message) }
            }
        ) {
            val buildings = useCase.invoke()
            _uiState.update { it.copy(isLoading = false, buildings = buildings) }
        }
    }
}
