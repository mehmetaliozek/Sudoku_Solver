package com.mehmetaliozek.sudokusolver.ui.components

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Upload
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import com.mehmetaliozek.sudokusolver.ui.theme.colors

@Suppress("DEPRECATION")
@Composable
fun ImagePicker(onImagePicked: (Uri) -> Unit, isLoading: Boolean) {
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let { onImagePicked(it) }
    }

    FloatingActionButton(
        onClick = { if (!isLoading) launcher.launch("image/*") },
        contentColor = colors[2],
        containerColor = colors[0]
    ) {
        Icon(Icons.Rounded.Upload, "Floating action button.")
    }
}