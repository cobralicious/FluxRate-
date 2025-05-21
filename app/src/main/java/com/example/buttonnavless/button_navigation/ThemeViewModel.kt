package com.example.buttonnavless.button_navigation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ThemeViewModel : ViewModel() {
    private val _isDarkTheme = MutableStateFlow(false)
    val isDarkTheme: StateFlow<Boolean> = _isDarkTheme

    fun initTheme(context: Context) {
        viewModelScope.launch {
            ThemePreferences.getTheme(context).collectLatest { isDark ->
                _isDarkTheme.value = isDark
            }
        }
    }

    fun toggleTheme(context: Context) {
        viewModelScope.launch {
            val newTheme = !_isDarkTheme.value
            _isDarkTheme.value = newTheme
            ThemePreferences.saveTheme(context, newTheme)
        }
    }
}