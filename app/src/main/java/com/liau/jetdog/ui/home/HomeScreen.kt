package com.liau.jetdog.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.liau.jetdog.MainViewModel
import com.liau.jetdog.R
import com.liau.jetdog.core.di.Injector
import com.liau.jetdog.core.di.ViewModelFactory
import com.liau.jetdog.state.UiState
import com.liau.jetdog.ui.other.ErrorScreen


/**
 * Created by Budiliauw87 on 2022-10-17.
 * budiliauw87.github.io
 * Budiliauw87@gmail.com
 */
@Composable
fun HomeScreen(
    navController: NavHostController,
    onRequestDialog: () -> Unit,
    viewModel: MainViewModel = viewModel(
        factory = ViewModelFactory(Injector.provideRepository(LocalContext.current))
    )
) {
//    val refreshing = lazyPagingItems.loadState.refresh is LoadState.Loading
//    val pullRefreshState = rememberPullRefreshState(refreshing, { lazyPagingItems.refresh() })
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            LaunchedEffect(Unit) {
                viewModel.getDogBreeds()
            }
            viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
                when (uiState) {
                    is UiState.Loading -> {
                        CircularProgressIndicator(
                            modifier = Modifier.width(64.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant,
                        )
                    }

                    is UiState.Success -> {
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text(
                                stringResource(R.string.menu_home),
                                style = MaterialTheme.typography.titleLarge
                            )
                            Button(
                                onClick = { onRequestDialog() },
                                modifier = Modifier.padding(8.dp),
                            ) {
                                Text("Show Dialog")
                            }
                        }

                    }

                    is UiState.Error -> {
                        ErrorScreen(
                            uiState.errorMessage,
                            Icons.Filled.ErrorOutline,
                            onRefresh = { viewModel.getDogBreeds() }
                        )
                    }
                }
            }


        }
    }


}

@Preview(
    group = "Test",
    name = "Light Mode",
    showBackground = true,
    showSystemUi = true,
    device = "id:pixel_4"
)

@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
//    HomeScreen(
//        navController = navController,
//
//    )
}