package com.example.brutal.core.di

import com.example.brutal.core.data.local.LocalDatabase
import com.example.brutal.allbuilding.domain.usecases.GetBuildingsUseCase
import org.koin.dsl.module

val coreModules = module {
    single {
        LocalDatabase.create(get())
    }

    single {
        get<LocalDatabase>().buildingDao()
    }
}