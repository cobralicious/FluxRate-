package com.example.buttonnavless.button_navigation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CurrencyViewModel(private val api: CurrencyApi) : ViewModel() {

    private val _rates = MutableStateFlow<Map<String, Double>>(emptyMap())
    val rates: StateFlow<Map<String, Double>> = _rates

    init {
        loadRates()
    }

    fun loadRates() {
        viewModelScope.launch {
            try {
                val response = api.getRates()
                val mapRates = response.data.mapValues { it.value.value }
                _rates.value = mapRates
            } catch (e: Exception) {
                e.printStackTrace()
                _rates.value = emptyMap()
            }
        }
    }
}