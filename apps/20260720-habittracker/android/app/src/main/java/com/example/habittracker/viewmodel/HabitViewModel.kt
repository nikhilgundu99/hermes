package com.example.habittracker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.habittracker.data.model.Habit
import com.example.habittracker.data.model.HabitLog
import com.example.habittracker.data.repository.HabitRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalDate

class HabitViewModel(private val repository: HabitRepository) : ViewModel() {

    val habits: StateFlow<List<Habit>> = repository.habits
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun addHabit(name: String) {
        if (name.isBlank()) return
        viewModelScope.launch {
            repository.insert(Habit(name = name.trim()))
        }
    }

    fun toggleCompletion(habitId: Int, date: String, completed: Boolean) {
        viewModelScope.launch {
            repository.upsertLog(HabitLog(habitId = habitId, date = date, completed = completed))
        }
    }
}
