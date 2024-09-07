package com.jakub.brutal.core.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.jakub.brutal.core.data.models.BuildingModel

@Dao
interface BuildingDao {
    @Query("SELECT * FROM brutal")
    suspend fun getAll(): List<BuildingModel>
}
