package com.example.brutal.allbuilding.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.brutal.allbuilding.presentation.states.AllBuildingState
import com.example.brutal.core.presentation.theme.BrutalColors
import org.koin.android.ext.android.inject

class AllBuildingActivity : ComponentActivity() {

    private val viewModel: AllBuildingViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val state = viewModel.uiState.collectAsState()
            LaunchedEffect(key1 = Unit) {
                viewModel.getAllBuilding()
            }
            AllBuildingScreen(state)
        }
    }
}

@Composable
fun AllBuildingScreen(
    state: State<AllBuildingState>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .fillMaxSize()
            .padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .border(width = 1.dp, color = BrutalColors.darkGrey),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Brutal")
        }
        AnimatedVisibility(visible = state.value.isLoading || !state.value.errorMessage.isNullOrBlank()) {
            Text(text = if (state.value.isLoading) "Loading your data..." else state.value.errorMessage.toString())
        }
        LazyColumn {
            items(state.value.buildings) {
                Text(text = it)
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun AllBuildingScreenPreview() {
//    AllBuildingScreen()
//}
