package com.liau.jetdog

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.liau.jetdog.ui.theme.JetDogTheme
import com.liau.jetgithub.navigation.Screen
import com.liau.jetgithub.ui.component.BottomBar
import com.liaudev.jetgithub.ui.home.AboutScreen
import com.liaudev.jetgithub.ui.home.FavoriteScreen
import com.liaudev.jetgithub.ui.home.HomeScreen

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
fun JetDogApp(){
    JetDogTheme {
        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        Scaffold(
            topBar = {},
            bottomBar ={BottomBar(navController)},
            floatingActionButton ={},
        ){
            NavHost(
                navController = navController,
                startDestination = Screen.Home.route,
                modifier = Modifier.padding(it)
            ) {
                composable(Screen.Home.route){
                    HomeScreen(navController)
                }
                composable(Screen.Favorite.route){
                    FavoriteScreen(navController)
                }
                composable(Screen.About.route){
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