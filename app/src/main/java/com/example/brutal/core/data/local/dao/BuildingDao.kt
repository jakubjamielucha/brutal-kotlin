package com.example.brutal.core.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.brutal.core.data.models.BuildingModel

@Dao
interface BuildingDao {
    @Query("SELECT * FROM brutal")
    suspend fun getAll(): List<BuildingModel>
}
