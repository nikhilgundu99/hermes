package com.example.habittracker.data.db

import androidx.room.*
import com.example.habittracker.data.model.Habit
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitDao {
    @Query('SELECT * FROM habits ORDER BY createdAt DESC')
    fun getAllHabits(): Flow<List<Habit>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(habit: Habit): Long

    @Update
    suspend fun update(habit: Habit)
}
