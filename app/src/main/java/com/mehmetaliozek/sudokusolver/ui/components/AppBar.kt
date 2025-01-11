package com.mehmetaliozek.sudokusolver.ui.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import com.mehmetaliozek.sudokusolver.ui.theme.colors
import com.mehmetaliozek.sudokusolver.ui.theme.comfortaaFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Sudoku Solver",
                fontFamily = comfortaaFontFamily,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineSmall,
                color = colors[2],
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = colors[0]),
//        navigationIcon = {
//            IconButton(
//                onClick = { },
//                colors = IconButtonDefaults.iconButtonColors(contentColor = CosmicLatte)
//            ) {
//                Icon(
//                    imageVector = Icons.Filled.Menu,
//                    contentDescription = "Menu"
//                )
//            }
//        },
    )
}
