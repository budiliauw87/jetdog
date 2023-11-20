package com.liau.jetdog.navigation

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Created by Budiman on 18/01/2023.
 * Email budiliauw87@gmail.com
 * Github github.com/budiliauw87
 */

data class BottomNavigationItem(
    val title: String,
    val icon: ImageVector,
    val screen: Screen
)
