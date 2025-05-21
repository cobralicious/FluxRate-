package com.example.buttonnavless

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.buttonnavless.button_navigation.CurrencyApi
import com.example.buttonnavless.button_navigation.CurrencyViewModel
import com.example.buttonnavless.button_navigation.MainScreen
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val viewModel = provideCurrencyViewModel()
            MainScreen(navController = navController, viewModel = viewModel)

        }
    }
}

@Composable
fun provideCurrencyViewModel(): CurrencyViewModel {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.currencyapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val api = retrofit.create(CurrencyApi::class.java)
    return viewModel { CurrencyViewModel(api) }
}