package com.mehmetaliozek.sudokusolver.ui.screens

import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mehmetaliozek.sudokusolver.ads.BannerAd
import com.mehmetaliozek.sudokusolver.ads.InterstitialAdManager
import com.mehmetaliozek.sudokusolver.ui.components.AppBar
import com.mehmetaliozek.sudokusolver.ui.components.Body
import com.mehmetaliozek.sudokusolver.ui.components.CreatedBy
import com.mehmetaliozek.sudokusolver.ui.components.ImagePicker
import com.mehmetaliozek.sudokusolver.ui.theme.colors
import com.mehmetaliozek.sudokusolver.viewmodel.SudokuViewModel

@Composable
fun Home() {
    val sudokuViewModel: SudokuViewModel = viewModel()
    val sudoku by sudokuViewModel.sudoku.observeAsState(null)
    val errorMessage by sudokuViewModel.errorMessage.observeAsState("")
    val isLoading by sudokuViewModel.isLoading.observeAsState(false)

    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val context = LocalContext.current

    imageUri?.let { uri ->
        LaunchedEffect(uri) {
            sudokuViewModel.solve(uri, context)
            InterstitialAdManager.showAd(context)
        }
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding(),
        containerColor = colors[2],
        topBar = {
            AppBar()
        },
        bottomBar = {
            BottomAppBar(containerColor = colors[2]) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CreatedBy()
                    BannerAd(Modifier.fillMaxWidth())
                }
            }
        },
        floatingActionButton = {
            ImagePicker(
                onImagePicked = { uri ->
                    if (imageUri != null && imageUri == uri) {
                        return@ImagePicker
                    }
                    sudokuViewModel.reset()
                    imageUri = uri
                },
                isLoading = isLoading
            )
        },
        content = { innerPadding ->
            Body(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                sudoku,
                errorMessage,
                isLoading
            )
        }
    )

}

