package com.example.buttonnavless.button_navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavGraph(
    navHostController: NavHostController,
    viewModel: CurrencyViewModel,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navHostController,
        startDestination = "screen_1",
        modifier = modifier.statusBarsPadding()
    ) {
        composable("screen_1") {
            Screen1(viewModel = viewModel)
        }
        composable("screen_2") {
            Screen2(viewModel = viewModel)
        }
        composable("screen_3") {
            Screen3()
        }
        composable("screen_4") {
            Screen4()
        }
    }
}