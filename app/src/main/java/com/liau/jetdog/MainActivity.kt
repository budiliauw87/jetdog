package com.liau.jetdog

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.liau.jetdog.ui.home.HomeScreen
import com.liau.jetdog.ui.other.DialogSetting
import com.liau.jetdog.ui.other.DogTopBar
import com.liau.jetdog.ui.theme.JetDogTheme
import com.liau.jetgithub.navigation.Screen
import com.liau.jetgithub.ui.component.BottomBar
import com.liaudev.jetgithub.ui.home.AboutScreen
import com.liaudev.jetgithub.ui.home.FavoriteScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetDogApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JetDogApp() {
    JetDogTheme {
        val default_route = Screen.Home.route // Home
        val navController = rememberNavController()

        var routeTitle by remember { mutableStateOf(default_route) }
        var openDialogSetting by remember { mutableStateOf(false) }
        Scaffold(
            topBar = {
                DogTopBar(
                    routeTitle = routeTitle,
                    onClickAction = {},
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
                    routeTitle = stringResource(R.string.menu_home)
                    HomeScreen(navController, { openDialogSetting  = !openDialogSetting })
                }
                composable(Screen.Favorite.route) {
                    routeTitle = stringResource(R.string.menu_favorite)
                    FavoriteScreen(navController)
                }
                composable(Screen.About.route) {
                    routeTitle = stringResource(R.string.menu_about)
                    AboutScreen(navController)
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = "id:pixel_5"
)
@Preview(
    name = "Dark Mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showSystemUi = true,
    device = "id:pixel_4"
)
@Composable
fun JetDogAppPreview() {
    JetDogApp()
}