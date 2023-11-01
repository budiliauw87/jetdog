package com.liau.jetdog.ui.other

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay


/**
 * Created by Budiliauw87 on 2023-11-01.
 * budiliauw87.github.io
 * Budiliauw87@gmail.com
 */

@Composable
fun LoadingScreen() {

}

@Preview(
    group = "Test",
    showBackground = true,
    device = "id:pixel_4"
)
@Composable
fun LoadingScreenPreview() {
    LoadingScreen()
}