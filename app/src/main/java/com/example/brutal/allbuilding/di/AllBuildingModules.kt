package com.example.brutal.allbuilding.di

import com.example.brutal.allbuilding.data.AllBuildingRepository
import com.example.brutal.allbuilding.data.AllBuildingRepositoryImpl
import com.example.brutal.allbuilding.domain.usecases.GetBuildingsUseCase
import com.example.brutal.allbuilding.presentation.AllBuildingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val allBuildingModules = module {
    single { AllBuildingRepositoryImpl(get()) } bind AllBuildingRepository::class
    factory {
        GetBuildingsUseCase(get())
    }
    viewModel { AllBuildingViewModel(get()) }
}
