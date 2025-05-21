package com.example.buttonnavless.button_navigation

import com.example.buttonnavless.R

sealed class BottomItem(val title: String, val iconId: Int, val route: String) {
    object Screen1: BottomItem("Currencies", R.drawable.main_menu, "screen_1")
    object Screen2: BottomItem("Exchange", R.drawable.exchange, "screen_2")
    object Screen3: BottomItem("Coming soon", R.drawable.aboutme, "screen_3")
    object Screen4: BottomItem("Settings", R.drawable.settings, "screen_4")
}