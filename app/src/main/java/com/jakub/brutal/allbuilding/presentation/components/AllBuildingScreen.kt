package com.jakub.brutal.allbuilding.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import com.jakub.brutal.allbuilding.presentation.AllBuildingViewModel
import com.jakub.brutal.allbuilding.presentation.states.AllBuildingUiEvent
import com.jakub.brutal.allbuilding.presentation.states.AllBuildingUiState
import com.jakub.brutal.core.presentation.components.BrutalHeader
import org.koin.androidx.compose.koinViewModel

@Composable
fun AllBuildingScreen(
    modifier: Modifier = Modifier,
    viewModel: AllBuildingViewModel = koinViewModel(),
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    LaunchedEffect(Unit) {
        viewModel.uiEvent.flowWithLifecycle(lifecycleOwner.lifecycle).collect {
            // Add Action
        }
    }
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val onEvent = remember {
        { event: AllBuildingUiEvent ->
            viewModel.onEvent(event)
        }
    }
    AllBuildingScreen(uiState, modifier, onEvent)
}

@Composable
private fun AllBuildingScreen(
    uiState: AllBuildingUiState,
    modifier: Modifier = Modifier,
    onUiEvent: (AllBuildingUiEvent) -> Unit = {}
) {
    Column(
        modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BrutalHeader(
            modifier = Modifier
                .padding(vertical = 24.dp)
        )
        AnimatedVisibility(visible = uiState.isLoading || !uiState.errorMessage.isNullOrBlank()) {
            Text(text = if (uiState.isLoading) "Loading your data..." else uiState.errorMessage.toString())
        }
        LazyColumn(
            modifier = Modifier.clip(RoundedCornerShape(16.dp)),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
        ) {
            items(uiState.buildings) {
                BuildingCard(it, onUiEvent = onUiEvent)
            }
        }
    }
}

@Preview
@Composable
private fun AllBuildingScreenPreview() {
    AllBuildingScreen(AllBuildingUiState())
}
