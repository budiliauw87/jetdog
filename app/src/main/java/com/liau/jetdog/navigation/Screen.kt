package com.liau.jetdog.navigation

/**
 * Created by Budiman on 18/01/2023.
 * Email budiliauw87@gmail.com
 * Github github.com/budiliauw87
 */
sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Favorite : Screen("favorite")
    object About : Screen("about")
    object DetailUser : Screen("detail")
    object Labs : Screen("labs")

    //labs
}