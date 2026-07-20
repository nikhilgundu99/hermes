package com.example.habittracker.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = 'habit_logs')
data class HabitLog(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val habitId: Int,
    val date: String,
    val completed: Boolean
)
