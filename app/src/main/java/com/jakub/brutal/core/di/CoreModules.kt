package com.jakub.brutal.core.di

import com.jakub.brutal.core.data.local.LocalDatabase
import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.named
import org.koin.dsl.module

val coreModules = module {
    single {
        LocalDatabase.create(get())
    }

    single {
        get<LocalDatabase>().buildingDao()
    }

    single(named("io")) {
        Dispatchers.IO
    }
}