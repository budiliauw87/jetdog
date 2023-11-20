package com.liau.jetdog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.liau.jetdog.navigation.Screen
import com.liau.jetdog.ui.component.BottomBar
import com.liau.jetdog.ui.home.AboutScreen
import com.liau.jetdog.ui.home.FavoriteScreen
import com.liau.jetdog.ui.home.HomeScreen
import com.liau.jetdog.ui.labs.LabsScreen
import com.liau.jetdog.ui.other.DialogSetting
import com.liau.jetdog.ui.other.DogTopBar
import com.liau.jetdog.ui.theme.JetDogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetDogApp()
        }
    }
}

@Composable
fun JetDogApp() {
    JetDogTheme {
        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        var openDialogSetting by remember { mutableStateOf(false) }
        Scaffold(
            topBar = {
                DogTopBar(
                    routeTitle = currentDestination?.route.toString(),
                    onClickAction = { openDialogSetting = !openDialogSetting },
                    onClickNavIcon = {}
                )
            },
            bottomBar = { BottomBar(navController) },
            floatingActionButton = {},
        ) {
            when {
                openDialogSetting -> {
                    DialogSetting(
                        onDismissRequest = {
                            openDialogSetting = false
                        }
                    )
                }
            }
            NavHost(
                navController = navController,
                startDestination = Screen.Home.route,
                modifier = Modifier.padding(it)
            ) {
                composable(Screen.Home.route) {
                    HomeScreen()
                }
                composable(Screen.Favorite.route) {
                    FavoriteScreen()
                }
                composable(Screen.Labs.route) {
                    LabsScreen()
                }
                composable(Screen.About.route) {
                    AboutScreen()
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun JetDogAppPreview() {
    JetDogApp()
}