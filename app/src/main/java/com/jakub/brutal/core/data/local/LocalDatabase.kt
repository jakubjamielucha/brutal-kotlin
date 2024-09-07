package com.jakub.brutal.core.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jakub.brutal.core.data.local.dao.BuildingDao
import com.jakub.brutal.core.data.models.BuildingModel

@Database(entities = [BuildingModel::class], version = 1, exportSchema = false)
abstract class LocalDatabase : RoomDatabase() {

    abstract fun buildingDao(): BuildingDao

    companion object {
        fun create(context: Context): LocalDatabase {
            return Room.databaseBuilder(context, LocalDatabase::class.java, "brutal")
                .createFromAsset("brutal.db")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}