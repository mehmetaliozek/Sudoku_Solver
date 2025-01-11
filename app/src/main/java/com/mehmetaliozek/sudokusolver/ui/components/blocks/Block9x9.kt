package com.mehmetaliozek.sudokusolver.ui.components.blocks

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.mehmetaliozek.sudokusolver.data.model.Sudoku
import com.mehmetaliozek.sudokusolver.ui.theme.colors

@Composable
fun Block9x9(modifier: Modifier, sudoku: Sudoku) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val outerMargin = 16.dp

    Column(
        modifier = modifier,
        content = {
            for (cBlock in 0..2) {
                Row {
                    for (rBlock in 0..2) {
                        val color = if ((cBlock + rBlock) % 2 == 0) colors[1].copy(alpha = 0.5f) else colors[1]
                        Block3x3(
                            cBlock = cBlock,
                            rBlock = rBlock,
                            size = ((screenWidth - (2 * outerMargin.value).dp) / 9),
                            color = color,
                            sudoku = sudoku
                        )
                    }
                }
            }
        }
    )
}