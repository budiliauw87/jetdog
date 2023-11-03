package com.liau.jetdog.ui.other

import android.service.autofill.OnClickAction
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.liau.jetdog.R


/**
 * Created by Budiliauw87 on 2023-11-02.
 * budiliauw87.github.io
 * Budiliauw87@gmail.com
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DogTopBar(
    routeTitle: String,
    onClickNavIcon: () -> Unit,
    onClickAction: () -> Unit
) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(text = routeTitle.replaceFirstChar { it.uppercase() })
        },
        navigationIcon = {
            IconButton(onClick = { onClickNavIcon() }) {
                if (routeTitle == "detail") {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.menu_back)
                    )
                } else {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = stringResource(R.string.menu_search)
                    )
                }

            }
        },
        actions = {
            IconButton(onClick = { onClickAction() }) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = stringResource(R.string.menu_settings)
                )
            }
        },
    )
}

@Preview(
    showBackground = true,
)
@Composable
fun DogTopBarPreview() {
    DogTopBar(
        routeTitle = stringResource(R.string.menu_home),
        onClickAction = {},
        onClickNavIcon = {}
    )
}