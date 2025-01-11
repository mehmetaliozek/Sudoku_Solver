package com.mehmetaliozek.sudokusolver.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.mehmetaliozek.sudokusolver.ads.InterstitialAdManager
import com.mehmetaliozek.sudokusolver.data.model.Sudoku
import com.mehmetaliozek.sudokusolver.ui.components.blocks.Block9x9
import com.mehmetaliozek.sudokusolver.ui.theme.colors
import com.mehmetaliozek.sudokusolver.ui.theme.comfortaaFontFamily

@Composable
fun Body(modifier: Modifier, sudoku: Sudoku?, errorMessage: String?, isLoading: Boolean) {
    Column(modifier = modifier) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            when {
                sudoku != null -> {
                    Block9x9(
                        modifier = Modifier,
                        sudoku = sudoku
                    )
                }

                isLoading -> {
                    CircularProgressIndicator(color = colors[0])
                }

                errorMessage.isNullOrEmpty() -> {
                    Text(
                        "Upload sudoku image",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = comfortaaFontFamily,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    )
                }

                else -> {
                    Text(
                        errorMessage.orEmpty(),
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = comfortaaFontFamily,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        ),
                    )
                }
            }
        }
    }
}