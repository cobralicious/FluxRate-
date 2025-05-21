package com.example.buttonnavless.button_navigation

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

suspend fun fetchRatesFromApi(currencies: List<String>): Map<String, Double> {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }

    try {
        val response: ExchangeRatesResponse = client.get("https://api.exchangerate.host/latest?base=USD").body()
        return currencies.associateWith { response.rates[it] ?: 0.0 }
    } catch (e: Exception) {
        e.printStackTrace()
        return currencies.associateWith { 0.0 }
    } finally {
        client.close()
    }
}

@Serializable
data class ExchangeRatesResponse(
    val rates: Map<String, Double>
)
