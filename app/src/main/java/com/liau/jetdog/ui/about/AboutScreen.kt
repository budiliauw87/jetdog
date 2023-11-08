package com.liaudev.jetgithub.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.liau.jetdog.R


/**
 * Created by Budiliauw87 on 2022-10-17.
 * budiliauw87.github.io
 * Budiliauw87@gmail.com
 */
@Composable
fun AboutScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                stringResource(R.string.menu_about),
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}

@Preview(
    name = "Light Mode",
)
@Preview(
    name = "Dark Mode", showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun AboutScreenPreview() {
    val navController = rememberNavController()
    AboutScreen(navController)
}