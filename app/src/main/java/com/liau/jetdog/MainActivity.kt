package com.liau.jetdog

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.android.material.color.MaterialColors
import com.liau.jetdog.ui.home.HomeScreen
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
fun JetDogApp(){
    JetDogTheme {
        val navController = rememberNavController()
        Scaffold(
            topBar = { DogTopBar() },
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