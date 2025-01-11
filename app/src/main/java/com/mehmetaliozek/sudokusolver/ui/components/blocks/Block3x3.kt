package com.mehmetaliozek.sudokusolver.ui.components.blocks

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mehmetaliozek.sudokusolver.data.model.Sudoku
import com.mehmetaliozek.sudokusolver.ui.theme.colors

@Composable
fun Block3x3(cBlock: Int, rBlock: Int, size: Dp, color: Color, sudoku: Sudoku) {
    Box(
        modifier = Modifier.border(2.dp, Color.Black),
        content = {
            Column {
                for (c in 0..2) {
                    Row {
                        for (r in 0..2) {
                            val index = cBlock * 27 + rBlock * 3 + c * 9 + r
                            val tcolor = if (sudoku.solution[index] == sudoku.solvedNumbers[index])
                                colors[3]
                            else
                                Color.Black
                            Block(
                                size = size,
                                bgColor = color,
                                textColor = tcolor,
                                text = "${sudoku.solution[index]}"
                            )
                        }
                    }
                }
            }
        }
    )
}