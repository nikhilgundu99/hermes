package com.example.habittracker.data.db

import androidx.room.*
import com.example.habittracker.data.model.HabitLog
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitLogDao {
    @Query('SELECT * FROM habit_logs WHERE habitId = :habitId AND date = :date LIMIT 1')
    fun getLog(habitId: Int, date: String): Flow<HabitLog?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(log: HabitLog)
}
