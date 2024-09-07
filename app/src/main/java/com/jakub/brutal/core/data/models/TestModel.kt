package com.jakub.brutal.core.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("test")
data class TestModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "unique_id")
    val uniqueId: Int,
    @ColumnInfo(name = "test")
    val test: String,
)
