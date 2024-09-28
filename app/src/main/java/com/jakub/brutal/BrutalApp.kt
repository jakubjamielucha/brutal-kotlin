package com.jakub.brutal

import android.app.Application
import com.jakub.brutal.allbuilding.di.allBuildingModules
import com.jakub.brutal.core.di.coreModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.ksp.generated.defaultModule

class BrutalApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@BrutalApp)
            modules(coreModules, allBuildingModules, defaultModule)
        }
    }
}