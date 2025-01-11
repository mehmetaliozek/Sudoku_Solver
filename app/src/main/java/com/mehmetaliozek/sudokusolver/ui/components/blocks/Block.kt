package com.mehmetaliozek.sudokusolver.ui.components.blocks

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mehmetaliozek.sudokusolver.ui.theme.comfortaaFontFamily

@Composable
fun Block(size: Dp, bgColor: Color, textColor: Color, text: String) {
    Card(
        modifier = Modifier
            .size(size)
            .border(0.5.dp, Color.Black.copy(alpha = 0.5f)),
        shape = RoundedCornerShape(0.dp),
        colors = CardDefaults.cardColors(containerColor = bgColor),
        content =
        {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                content =
                {
                    Text(
                        text = text,
                        style = TextStyle(
                            color = textColor,
                            fontSize = 22.sp,
                            fontFamily = comfortaaFontFamily
                        )
                    )
                }
            )
        }
    )
}