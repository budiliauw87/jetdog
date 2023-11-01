package com.liau.jetdog.ui.other

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


/**
 * Created by Budiliauw87 on 2023-10-29.
 * budiliauw87.github.io
 * Budiliauw87@gmail.com
 */
@Composable
fun ErrorScreen(
    titleError: String,
    iconError: ImageVector,
    onRefresh: () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(1f),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Icon(
            imageVector = iconError,
            contentDescription = "Error icons",
            modifier = Modifier.size(width = 100.dp, height = 100.dp)
        )
        Text(
            text = titleError,
            modifier = Modifier.padding(8.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            onClick = onRefresh,
        ) {
            Text(text = "Refresh", color = MaterialTheme.colorScheme.background)
        }
    }
}
@Preview(
    group="Test",
    showBackground = true,
    device = "id:pixel_4")
@Composable
fun ErrorScreenPreview() {
    ErrorScreen(
        titleError = "Something wrong",
        iconError = Icons.Filled.ErrorOutline,
        onRefresh = {}
    )
}