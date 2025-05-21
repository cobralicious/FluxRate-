package com.example.buttonnavless.button_navigation

import com.example.buttonnavless.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApi {
    @GET("v3/latest")
    suspend fun getRates(@Query("apikey") apiKey: String = BuildConfig.API_KEY): ApiResponse
}


data class ApiResponse(
    val data: Map<String, CurrencyData>
)

data class CurrencyData(
    val code: String,
    val value: Double
)