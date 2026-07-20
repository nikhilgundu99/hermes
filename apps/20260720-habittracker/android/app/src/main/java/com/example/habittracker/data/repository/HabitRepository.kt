package com.example.habittracker.data.repository

import com.example.habittracker.data.db.AppDatabase
import com.example.habittracker.data.db.HabitDao
import com.example.habittracker.data.db.HabitLogDao
import com.example.habittracker.data.model.Habit
import com.example.habittracker.data.model.HabitLog
import kotlinx.coroutines.flow.Flow

class HabitRepository(private val db: AppDatabase) {
    val habits: Flow<List<Habit>> = db.habitDao().getAllHabits()

    suspend fun insert(habit: Habit): Long = db.habitDao().insert(habit)

    suspend fun upsertLog(log: HabitLog) = db.habitLogDao().upsert(log)
}
