package com.example.habittracker.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.habittracker.data.model.Habit
import com.example.habittracker.data.model.HabitLog

@Database(entities = [Habit::class, HabitLog::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun habitDao(): HabitDao
    abstract fun habitLogDao(): HabitLogDao
}
