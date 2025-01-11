package com.mehmetaliozek.sudokusolver

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import com.google.android.gms.ads.MobileAds
import com.mehmetaliozek.sudokusolver.ads.InterstitialAdManager
import com.mehmetaliozek.sudokusolver.ui.screens.Home
import com.mehmetaliozek.sudokusolver.ui.theme.SudokuSolverTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        MobileAds.initialize(this) {}
        InterstitialAdManager.loadAd(this)
        setContent {
            SudokuSolverTheme {
                Home()
            }
        }
    }
}