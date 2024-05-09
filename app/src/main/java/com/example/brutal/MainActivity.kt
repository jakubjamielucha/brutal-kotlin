package com.example.brutal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.brutal.models.Person
import com.example.brutal.ui.theme.BrutalTheme

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val persons by viewModel.persons.collectAsState(initial = listOf())
            BrutalTheme {
                Name(persons) { viewModel.fetchPerson() }
            }
        }
    }
}

@Suppress("NonSkippableComposable")
@Composable
fun Name(persons: List<Person>, onButtonClick: () -> Unit = {}) {
    Column {
        LazyColumn {
            items(persons) {
                Text(text = it.name)
            }
        }
        Button(onClick = onButtonClick) {
            
        }
    }
}
