package com.example.brutal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brutal.models.Person
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private lateinit var getPersonUseCase: GetPersonUseCase

    private val _persons = MutableStateFlow<List<Person>>(listOf())
    val persons get() = _persons.asStateFlow()

    init {
        getPersonUseCase = GetPersonUseCase()
    }

    fun fetchPerson() = viewModelScope.launch {
        val newPersons = getPersonUseCase.invoke()
        _persons.update { it + newPersons }
    }
}
