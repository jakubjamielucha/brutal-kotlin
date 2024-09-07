package com.jakub.brutal.allbuilding.di

import com.jakub.brutal.allbuilding.data.AllBuildingRepository
import com.jakub.brutal.allbuilding.data.AllBuildingRepositoryImpl
import com.jakub.brutal.allbuilding.domain.usecases.GetBuildingsUseCase
import com.jakub.brutal.allbuilding.presentation.AllBuildingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val allBuildingModules = module {
    single { AllBuildingRepositoryImpl(get()) } bind AllBuildingRepository::class
    factory {
        GetBuildingsUseCase(get())
    }
    viewModel { AllBuildingViewModel(get(), get(named("io"))) }
}
