package com.mehmetaliozek.sudokusolver.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.mehmetaliozek.sudokusolver.ui.theme.comfortaaFontFamily

@Composable
fun CreatedBy() {
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 6.sp,
                    fontFamily = comfortaaFontFamily,
                    fontWeight = FontWeight.Normal,
                )
            ) {
                append("Created by ")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 8.sp,
                    fontFamily = comfortaaFontFamily,
                    fontWeight = FontWeight.Bold,
                )
            ) {
                append("Bedirhan ÇELİK ")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 6.sp,
                    fontFamily = comfortaaFontFamily,
                    fontWeight = FontWeight.Normal,
                )
            ) {
                append("& ")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 8.sp,
                    fontFamily = comfortaaFontFamily,
                    fontWeight = FontWeight.Bold,
                )
            ) {
                append("Mehmet Ali ÖZEK")
            }
        }
    )
}