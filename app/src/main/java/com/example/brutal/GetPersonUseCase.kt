package com.example.brutal

import com.example.brutal.models.Person
import kotlinx.coroutines.delay

class GetPersonUseCase {
    suspend fun invoke(): List<Person> {
        delay(250L)
        return listOf(
            Person("Jakub", 20),
            Person("Joseph", 20),
            Person("Random", 21),
        )
    }
}