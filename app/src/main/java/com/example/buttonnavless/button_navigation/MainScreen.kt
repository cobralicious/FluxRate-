package com.example.buttonnavless.button_navigation

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.compose.material3.ExperimentalMaterial3Api

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController, viewModel: CurrencyViewModel) {
    Scaffold(
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    ) { paddingValues ->
        NavGraph(
            navHostController = navController,
            viewModel = viewModel,
            modifier = Modifier.padding(paddingValues)
        )
    }
}