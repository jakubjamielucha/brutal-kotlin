package com.jakub.brutal.mainmenu.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.jakub.brutal.allbuilding.presentation.AllBuildingActivity
import com.jakub.brutal.mainmenu.presentation.model.MainMenuEvent
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainMenuActivity : ComponentActivity() {

    private val viewModel by viewModel<MainMenuScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            viewModel.uiEvent.flowWithLifecycle(lifecycle).collect {
                when (it) {
                    MainMenuEvent.NavigateToAllBuildings -> startActivity(
                        Intent(
                            this@MainMenuActivity,
                            AllBuildingActivity::class.java
                        )
                    )

                    else -> Unit
                }
            }
        }
        setContent {
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            MainMenuScreen(uiState.menuList, onEvent = {
                viewModel.onEvent(it)
            })
        }
    }
}
