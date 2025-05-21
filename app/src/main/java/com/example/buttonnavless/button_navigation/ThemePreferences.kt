package com.example.buttonnavless.button_navigation

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Define DataStore
val Context.themeDataStore: DataStore<Preferences> by preferencesDataStore(name = "theme_prefs")

object ThemePreferences {
    private val IS_DARK_THEME = booleanPreferencesKey("is_dark_theme")

    // Save theme preference
    suspend fun saveTheme(context: Context, isDarkTheme: Boolean) {
        context.themeDataStore.edit { prefs ->
            prefs[IS_DARK_THEME] = isDarkTheme
        }
    }

    // Read theme preference
    fun getTheme(context: Context): Flow<Boolean> {
        return context.themeDataStore.data.map { prefs ->
            prefs[IS_DARK_THEME] ?: false // Default to light theme
        }
    }
}